package com.backend.microservices.solicitud_microservice.estado;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.microservices.solicitud_microservice.tarifa.TarifaRequest;
import com.backend.microservices.solicitud_microservice.tarifa.TarifaResponse;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/estados")
@RequiredArgsConstructor
public class EstadoController {
    private final EstadoService service;

    @GetMapping()
    public ResponseEntity<List<EstadoResponse>> getAllEstados() {
        return ResponseEntity.ok(service.getAllEstados());
    }

    @PostMapping()
    public ResponseEntity<Integer> createEstado(@Valid @RequestBody EstadoRequest request) {
        return ResponseEntity.ok(service.createEstado(request));
    }

    @DeleteMapping("/{estadoId}")
    public ResponseEntity<Void> deleteEstado(@PathVariable("estadoId") Integer id) throws Exception {
        
        service.deleteEstado(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{estadoId}")
    public ResponseEntity<Void> updateEstado(
            @PathVariable Integer estadoId,
            @Valid @RequestBody EstadoRequest request) {

        service.updateEstado(estadoId, request);
        return ResponseEntity.accepted().build();
    }


    @GetMapping("/{estadoId}")
    public ResponseEntity<EstadoResponse> getEstadoById(@PathVariable("estadoId") Integer id) {
        return ResponseEntity.ok(service.getEstadoById(id));
    }
}
