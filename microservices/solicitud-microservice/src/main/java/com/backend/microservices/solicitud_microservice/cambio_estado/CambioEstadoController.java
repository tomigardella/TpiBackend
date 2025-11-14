package com.backend.microservices.solicitud_microservice.cambio_estado;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/cambios-estado")
@RequiredArgsConstructor
public class CambioEstadoController {

    private final CambioEstadoService service;

    @GetMapping
    public ResponseEntity<List<CambioEstadoResponse>> getAll() {
        return ResponseEntity.ok(service.getAllCambios());
    }

    @PostMapping
    public ResponseEntity<Integer> create(@Valid @RequestBody CambioEstadoRequest request) {
        return ResponseEntity.ok(service.createCambioEstado(request));
    }
}
