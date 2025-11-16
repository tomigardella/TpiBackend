package com.backend.microservices.geolocalizacion_microservice.geolocalizacion.service;

import com.backend.microservices.geolocalizacion_microservice.geolocalizacion.dto.DistanciaRequest;
import com.backend.microservices.geolocalizacion_microservice.geolocalizacion.dto.DistanciaResponse;
import com.backend.microservices.geolocalizacion_microservice.geolocalizacion.dto.PasoRuta;
import com.backend.microservices.geolocalizacion_microservice.geolocalizacion.dto.RutaRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@Service
@Slf4j
public class OsrmService {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String OSRM_URL = "http://localhost:5000";

    // Distancia usando DTO
    public DistanciaResponse obtenerDistancia(DistanciaRequest request) {
        String url = String.format(
                Locale.ENGLISH, // importante para decimales con punto
                "%s/route/v1/driving/%.6f,%.6f;%.6f,%.6f?overview=false",
                OSRM_URL,
                request.getLng_origen(), request.getLat_origen(),
                request.getLng_destino(), request.getLat_destino()
        );

        log.info("Consultando OSRM: {}", url);

        try {
            Map<String, Object> response = restTemplate.getForObject(url, Map.class);

            List<Map<String, Object>> routes = (List<Map<String, Object>>) response.get("routes");
            if (routes == null || routes.isEmpty()) {
                throw new RuntimeException("No se encontraron rutas en la respuesta de OSRM");
            }

            Map<String, Object> route = routes.get(0);

            double distancia_km = ((Number) route.get("distance")).doubleValue() / 1000;
            double duracion_min = ((Number) route.get("duration")).doubleValue() / 60;

            return new DistanciaResponse(distancia_km, duracion_min);

        } catch (Exception e) {
            log.error("Error al consultar OSRM", e);
            throw new RuntimeException("Error al obtener distancia: " + e.getMessage(), e);
        }
    }

    // Ruta usando DTO
    public List<PasoRuta> obtenerRuta(RutaRequest request) {
        String url = String.format(
                Locale.ENGLISH,
                "%s/route/v1/driving/%.6f,%.6f;%.6f,%.6f?overview=full&steps=true",
                OSRM_URL,
                request.getLng_origen(), request.getLat_origen(),
                request.getLng_destino(), request.getLat_destino()
        );

        log.info("Consultando OSRM (ruta completa): {}", url);

        try {
            Map<String, Object> response = restTemplate.getForObject(url, Map.class);

            List<Map<String, Object>> routes = (List<Map<String, Object>>) response.get("routes");
            if (routes == null || routes.isEmpty()) {
                throw new RuntimeException("No se encontraron rutas en la respuesta de OSRM");
            }

            Map<String, Object> route = routes.get(0);
            List<Map<String, Object>> legs = (List<Map<String, Object>>) route.get("legs");

            List<PasoRuta> pasos = new ArrayList<>();
            for (Map<String, Object> leg : legs) {
                List<Map<String, Object>> steps = (List<Map<String, Object>>) leg.get("steps");
                for (Map<String, Object> step : steps) {
                    String instruccion = (String) step.get("name");
                    double distancia_m = ((Number) step.get("distance")).doubleValue();
                    double duracion_min = ((Number) step.get("duration")).doubleValue() / 60;
                    pasos.add(new PasoRuta(instruccion, distancia_m, duracion_min));
                }
            }

            return pasos;

        } catch (Exception e) {
            log.error("Error al consultar OSRM", e);
            throw new RuntimeException("Error al obtener ruta: " + e.getMessage(), e);
        }
    }
}
