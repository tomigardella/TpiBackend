package com.backend.microservices.depositos_microservice.estadiaDeposito;

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
@RequestMapping("/api/estadias")
@RequiredArgsConstructor
public class EstadiaDepositoController {
    
    private final EstadiaDepositoService service;

    @GetMapping()
    public ResponseEntity<List<EstadiaDepositoResponse>> getAllEstadiaDepositos() {
        return ResponseEntity.ok(service.getAllEstadiaDepositos());
    }

    @PostMapping()
    public ResponseEntity<Integer> createEstadiaDeposito(@Valid @RequestBody EstadiaDepositoRequest request) {
        return ResponseEntity.ok(service.createEstadiaDeposito(request));
    }

    @PutMapping("/{id}/salida")
    public ResponseEntity<Void> registrarSalida(@PathVariable Integer id) {
        service.registrarSalida(id);
        return ResponseEntity.accepted().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEstadiaDeposito(@PathVariable Integer id) {
        service.deleteEstadiaDeposito(id);
        return ResponseEntity.noContent().build();
    }
}
