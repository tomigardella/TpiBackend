package com.backend.microservices.solicitud_microservice.tarifa;

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
@RequestMapping("/api/tarifas")
@RequiredArgsConstructor
public class TarifaController {
    
    private final TarifaService service;

    @GetMapping()
    public ResponseEntity<List<TarifaResponse>> getAllTarifas() {
        return ResponseEntity.ok(service.getAllTarifas());
    }

    @PostMapping()
    public ResponseEntity<Integer> createTarifa(@Valid @RequestBody TarifaRequest request) {
        return ResponseEntity.ok(service.createTarifa(request));
    }

    @DeleteMapping("/{tarifaId}")
    public ResponseEntity<Void> deleteTarifa(@PathVariable("tarifaId") Integer id) throws Exception {
        
        service.deleteTarifa(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{tarifaId}")
    public ResponseEntity<Void> updateTarifa(
        @PathVariable Integer tarifaId,
        @Valid @RequestBody TarifaRequest request) {

        service.updateTarifa(tarifaId, request);
        return ResponseEntity.accepted().build();
    }

    @GetMapping("/{tarifaId}")
    public ResponseEntity<TarifaResponse> getTarifaById(@PathVariable("tarifaId") Integer id) {
        return ResponseEntity.ok(service.getTarifaById(id));
    }  

    // /api/tarifas/calcular
    @PostMapping("/calcular/{tarifaId}")
    public ResponseEntity<TarifaCalculoResponse> calcularCostoEstimado(
        @PathVariable Integer tarifaId,
        @Valid @RequestBody TarifaCalculoRequest request
    ) {
            return ResponseEntity.ok(service.calcularCostoEstimado(request));
    }
}