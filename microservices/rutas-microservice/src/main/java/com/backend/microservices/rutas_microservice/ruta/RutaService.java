package com.backend.microservices.rutas_microservice.ruta;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.stereotype.Service;

import com.backend.microservices.rutas_microservice.client.SolicitudClient;
import com.backend.microservices.rutas_microservice.exceptions.RutaException;

import feign.FeignException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RutaService {

    private final RutaRepository repository;
    private final SolicitudClient solicitudClient;
    private final RutaMapper mapper;


    public List<RutaResponse> getAllRutas() {
        return repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    public void deleteRuta(Integer id) {
        if (!repository.existsById(id)) {
            throw new RutaException("Ruta no encontrada con id: " + id);
        }
        repository.deleteById(id);
    }


    public RutaResponse createRuta(RutaRequest request) {
        // Validar existencia de la solicitud
        try {
            solicitudClient.getSolicitudById(request.solicitudId());
        } catch (FeignException.NotFound e) {
            throw new RutaException("Solicitud no encontrada con id: " + request.solicitudId());
        }

        Ruta ruta = mapper.toRuta(request);  // convertir request a entidad Ruta
        ruta.setFechaCreacion(new Timestamp(System.currentTimeMillis()));

        repository.save(ruta);
        return mapper.toResponse(ruta);
    }

    public RutaResponse updateRuta(Integer id, RutaRequest request) {
        // Buscar la ruta existente
        Ruta ruta = repository.findById(id)
                .orElseThrow(() -> new RutaException("Ruta no encontrada con id: " + id));

        // Valido si existe una solicitud con ID
        try {
            solicitudClient.getSolicitudById(request.solicitudId());
        } catch (FeignException.NotFound e) {
            throw new RutaException("Solicitud no encontrada con id: " + request.solicitudId());
        }

        ruta.setCantidadTramos(request.cantidadTramos());
        ruta.setCantidadDepositos(request.cantidadDepositos());
        ruta.setDistanciaTotalKm(request.distanciaTotalKm());
        ruta.setFechaCreacion(request.fechaCreacion() != null ? request.fechaCreacion() : ruta.getFechaCreacion());
        ruta.setSolicitudId(request.solicitudId());

        ruta = repository.save(ruta);
        return mapper.toResponse(ruta);
    }

    public RutaResponse getRutaById(Integer rutaId) {
        return repository.findById(rutaId)
                .map(mapper::toResponse)
                .orElseThrow(() -> new RutaException("Ruta no encontrada con id: " + rutaId));
    }

}
