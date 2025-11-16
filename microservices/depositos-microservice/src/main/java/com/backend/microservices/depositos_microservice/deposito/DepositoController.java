package com.backend.microservices.depositos_microservice.deposito;

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
@RequestMapping("/api/depositos")
@RequiredArgsConstructor
public class DepositoController {
    
    private final DepositoService service;

    @GetMapping()
    public ResponseEntity<List<DepositoResponse>> getAllDepositos() {
        return ResponseEntity.ok(service.getAllDepositos());
    }

    @PostMapping()
    public ResponseEntity<Integer> createDeposito(@Valid @RequestBody DepositoRequest request) {
        return ResponseEntity.ok(service.createDeposito(request));
    }
    

    @PutMapping("/{depositoId}")
    public ResponseEntity<Void> updateDeposito(
            @PathVariable Integer depositoId,
            @Valid @RequestBody DepositoRequest request) {
        service.updateDeposito(depositoId, request);
        return ResponseEntity.accepted().build();
    }

    @GetMapping("/{depositoId}/contenedores")
    public ResponseEntity<?> getContenedoresByDeposito(@PathVariable Integer depositoId) {
        return ResponseEntity.ok(service.getContenedoresByDeposito(depositoId));
    }

    @DeleteMapping("/{depositoId}")
    public ResponseEntity<Void> deleteDeposito(@PathVariable Integer depositoId) {
        service.deleteDeposito(depositoId);
        return ResponseEntity.noContent().build();
    }
}
