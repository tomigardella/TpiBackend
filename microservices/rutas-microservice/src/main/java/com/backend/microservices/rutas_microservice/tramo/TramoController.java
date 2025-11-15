package com.backend.microservices.rutas_microservice.tramo;

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
@RequestMapping("/api/tramos")
@RequiredArgsConstructor
public class TramoController {

    private final TramoService service;

    // GET TRAMOS
    @GetMapping()
    public ResponseEntity<List<TramoResponse>> getAllTramos() {
        return ResponseEntity.ok(service.getAllTramos());
    }
    
    // POST TRAMO
    @PostMapping()
    public ResponseEntity<TramoResponse> createTramo(@Valid @RequestBody TramoRequest request) {
        return ResponseEntity.ok(service.createTramo(request));
    }

    // DELETE TRAMO
    @DeleteMapping("/{tramoId}")
    public ResponseEntity<Void> deleteTramo(@PathVariable("tramoId") Integer id) throws Exception {
        
        service.deleteTramo(id);
        return ResponseEntity.noContent().build();
    }

    // ACTUALIZAR CAMION DEL TRAMO
    @PutMapping("/{tramoId}/camion")
    public ResponseEntity<TramoResponse> updateTramo(
            @PathVariable Integer tramoId,
            @Valid @RequestBody TramoUpdateRequest request) {

        return ResponseEntity.accepted().body(service.updateTramo(tramoId, request));
    }

    // ACTUALIZAR ESTADO DEL TRAMO
    @PutMapping("/{tramoId}/estado")
    public ResponseEntity<TramoResponse> updateEstadoTramo(
            @PathVariable Integer tramoId,
            @Valid @RequestBody TramoEstadoRequest request) {

        return ResponseEntity.accepted().body(service.updateEstadoTramo(tramoId, request));
    }

    // INICIAR TRAMO
    @PutMapping("/{tramoId}/iniciar")
    public ResponseEntity<TramoResponse> iniciarTramo(
            @PathVariable Integer tramoId) {

        return ResponseEntity.ok(service.iniciarTramo(tramoId));
    }

    // FINALIZAR TRAMO
    @PutMapping("/{tramoId}/finalizar")
    public ResponseEntity<TramoResponse> finalizarTramo(
            @PathVariable Integer tramoId) {

        return ResponseEntity.ok(service.finalizarTramo(tramoId));
    }
}
