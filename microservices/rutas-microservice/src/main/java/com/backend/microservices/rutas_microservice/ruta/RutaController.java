package com.backend.microservices.rutas_microservice.ruta;

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
@RequestMapping("/api/rutas")
@RequiredArgsConstructor
public class RutaController {

    private final RutaService service;

    // GET Rutas
    @GetMapping()
    public ResponseEntity<List<RutaResponse>> getAllRutas() {
        return ResponseEntity.ok(service.getAllRutas());
    }

    // POST Ruta
    @PostMapping()
    public ResponseEntity<RutaResponse> createRuta(@Valid @RequestBody RutaRequest request) {
        return ResponseEntity.ok(service.createRuta(request));
    }

    // DELETE Ruta
    @DeleteMapping("/{rutaId}")
    public ResponseEntity<Void> deleteRuta(@PathVariable("rutaId") Integer id) throws Exception {
        
        service.deleteRuta(id);
        return ResponseEntity.noContent().build();
    }

    // ACTUALIZAR Ruta
    @PutMapping("/{rutaId}")
    public ResponseEntity<Void> updateRuta(
            @PathVariable Integer rutaId,
            @Valid @RequestBody RutaRequest request) {

        service.updateRuta(rutaId, request);
        return ResponseEntity.accepted().build();
    }

    // GET Ruta por id
    @GetMapping("/{rutaId}")
    public ResponseEntity<RutaResponse> getRutaById(@PathVariable("rutaId") Integer rutaId) {
        return ResponseEntity.ok(service.getRutaById(rutaId));
    }
}
