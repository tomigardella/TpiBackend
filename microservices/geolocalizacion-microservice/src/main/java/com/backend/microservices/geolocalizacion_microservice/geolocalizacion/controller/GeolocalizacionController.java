package com.backend.microservices.geolocalizacion_microservice.geolocalizacion.controller;

import com.backend.microservices.geolocalizacion_microservice.geolocalizacion.dto.*;
import com.backend.microservices.geolocalizacion_microservice.geolocalizacion.model.Geolocalizacion;
import com.backend.microservices.geolocalizacion_microservice.geolocalizacion.service.GeolocalizacionService;
import com.backend.microservices.geolocalizacion_microservice.geolocalizacion.service.OsrmService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/geolocalizaciones")
@RequiredArgsConstructor
public class GeolocalizacionController {

    private final GeolocalizacionService service;
    private final OsrmService osrmService;

    // --- CRUD Geolocalizaciones ---
    @PostMapping()
    public Geolocalizacion createGeolocalizacion(@RequestBody Geolocalizacion geo) {
        return service.createGeolocalizacion(geo);
    }

    @GetMapping()
    public List<Geolocalizacion> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Geolocalizacion getById(@PathVariable Integer id) {
        return service.getById(id)
                .orElseThrow(() -> new RuntimeException("No encontrada"));
    }

    @PutMapping("/{id}")
    public Geolocalizacion updateGeolocalizacion(@PathVariable Integer id, @RequestBody Geolocalizacion geo) {
        return service.updateGeolocalizacion(id, geo);
    }

    @DeleteMapping("/{id}")
    public String deleteGeolocalizacion(@PathVariable Integer id) {
        service.deleteGeolocalizacion(id);
        return "Eliminada geolocalización con id " + id;
    }

    // --- OSRM Endpoints usando JSON ---
    @GetMapping("/distancia")
    public DistanciaResponse distancia(@RequestBody DistanciaRequest request) {
        return osrmService.obtenerDistancia(request);
    }

    @GetMapping("/ruta")
    public List<PasoRuta> ruta(@RequestBody RutaRequest request) {
        return osrmService.obtenerRuta(request);
    }
}
