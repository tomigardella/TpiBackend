package com.backend.microservices.camiones_microservice.transportista;

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
@RequestMapping("/api/transportistas")
@RequiredArgsConstructor
public class TransportistaController {
    
    private final TransportistaService service;

    @GetMapping()
    public ResponseEntity<List<TransportistaResponse>> getAllTransportistas() {
        return ResponseEntity.ok(service.getAllTransportistas());
    }

    @PostMapping()
    public ResponseEntity<Integer> createTransportista(@Valid @RequestBody TransportistaRequest request) {
        return ResponseEntity.ok(service.createTransportista(request));
    }
    
    @DeleteMapping("/{transportistaId}")
    public ResponseEntity<Void> deleteTransportista(@PathVariable("transportistaId") Integer id) throws Exception {
        
        service.deleteTransportista(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{transportistaId}")
    public ResponseEntity<Void> updateTransportista(
            @PathVariable Integer transportistaId,
            @Valid @RequestBody TransportistaRequest request) {
        service.updateTransportista(transportistaId, request);
        return ResponseEntity.accepted().build();
    }
}
