package com.backend.microservices.camiones_microservice.camion;

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
@RequestMapping("/api/camiones")
@RequiredArgsConstructor
public class CamionController {

    private final CamionService service;

    @GetMapping()
    public ResponseEntity<List<CamionResponse>> getAllCamiones() {
        return ResponseEntity.ok(service.getAllCamiones());
    }

    @PostMapping()
    public ResponseEntity<Integer> createCamion(@Valid @RequestBody CamionRequest request) {
        return ResponseEntity.ok(service.createCamion(request));
    }

    @DeleteMapping("/{camionId}")
    public ResponseEntity<Void> deleteCamion(@PathVariable("camionId") Integer id) throws Exception {
        
        service.deleteCamion(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{camionId}")
    public ResponseEntity<Void> updateCamion(
            @PathVariable Integer camionId,
            @Valid @RequestBody CamionRequest request) {

        service.updateCamion(camionId, request);
        return ResponseEntity.accepted().build();
    }

    @GetMapping("/disponibles")
    public ResponseEntity<List<CamionResponse>> getCamionesDisponibles() {
        return ResponseEntity.ok(service.getCamionesDisponibles());
    }
}
