package com.backend.microservices.rutas_microservice.tipo_tramo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/tipos-tramo")
@RequiredArgsConstructor
public class TipoTramoController {
    
    private final TipoTramoService service;

    @GetMapping()
    public ResponseEntity<List<TipoTramoResponse>> getAllTiposTramo() {
        return ResponseEntity.ok(service.getAllTiposTramo());
    }

    @PostMapping()
    public ResponseEntity<TipoTramoResponse> createTipoTramo(@Valid @RequestBody TipoTramoRequest request) {
        return ResponseEntity.ok(service.createTipoTramo(request));
    }

    @DeleteMapping("/{tipoTramoId}")
    public ResponseEntity<Void> deleteTipoTramo(@PathVariable("tipoTramoId") Integer id) throws Exception {
        
        service.deleteTipoTramo(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{tipoTramoId}")
    public ResponseEntity<Void> updateTipoTramo(
            @PathVariable Integer tipoTramoId,
            @Valid @RequestBody TipoTramoRequest request) {

        service.updateTipoTramo(tipoTramoId, request);
        return ResponseEntity.accepted().build();
    }
    
}
