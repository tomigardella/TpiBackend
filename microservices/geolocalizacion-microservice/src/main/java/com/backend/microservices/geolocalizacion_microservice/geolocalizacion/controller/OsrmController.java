package com.backend.microservices.geolocalizacion_microservice.geolocalizacion.controller;

import com.backend.microservices.geolocalizacion_microservice.geolocalizacion.dto.*;
import com.backend.microservices.geolocalizacion_microservice.geolocalizacion.service.OsrmService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/maps")
@RequiredArgsConstructor
public class OsrmController {

    private final OsrmService service;

    // GET /api/maps/distancia
    @GetMapping("/distancia")
    public DistanciaResponse distancia(@RequestBody DistanciaRequest request) {
        return service.obtenerDistancia(request);
    }

    // GET /api/maps/ruta
    @GetMapping("/ruta")
    public List<PasoRuta> ruta(@RequestBody RutaRequest request) {
        return service.obtenerRuta(request);
    }
}
