package com.backend.microservices.solicitud_microservice.cambio_estado;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/cambios-estado")
@RequiredArgsConstructor
public class CambioEstadoController {

    private final CambioEstadoService service;

    @GetMapping
    public ResponseEntity<List<CambioEstadoResponse>> getAllCambios() {
        return ResponseEntity.ok(service.getAllCambios());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CambioEstadoResponse> getCambioById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getById(id));
    }

}
