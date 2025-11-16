package com.backend.microservices.contenedor_microservice.contenedor;

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

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/contenedores")
@RequiredArgsConstructor
public class ContenedorController {

    private final ContenedorService service;

    // GET CONTENEDORES
    @GetMapping()
    public ResponseEntity<List<ContenedorResponse>> getAllContenedores() {
        return ResponseEntity.ok(service.getAllContenedores());
    }

    @GetMapping("/{contenedorId}")
    public ResponseEntity<ContenedorResponse> getContenedorById(@PathVariable Integer contenedorId) {
        return ResponseEntity.ok(service.getContenedorById(contenedorId));
    }

    // POST CONTENEDOR
    @PostMapping()
    public ResponseEntity<ContenedorResponse> createContenedor(@Valid @RequestBody ContenedorRequest request) {
        return ResponseEntity.ok(service.createContenedor(request));
    }

    // DELETE CONTENEDOR
    @DeleteMapping("/{contenedorId}")
    public ResponseEntity<Void> deleteContenedor(@PathVariable("contenedorId") Integer id) throws Exception {
        
        service.deleteContenedor(id);
        return ResponseEntity.noContent().build();
    }

    // ACTUALIZAR CONTENEDOR
    @PutMapping("/{contenedorId}")
    public ResponseEntity<Void> updateContenedor(
            @PathVariable Integer contenedorId,
            @Valid @RequestBody ContenedorUpdateRequest request) {

        service.updateContenedor(contenedorId, request);
        return ResponseEntity.accepted().build();
    }

    @GetMapping("/estado")
    public ResponseEntity<List<ContenedorResponse>> getAllContenedoresEstado(
            @RequestParam("estado") String state
    ) {
        return ResponseEntity.ok(service.getAllContenedoresEstado(state));
    }

    @PostMapping("/{contenedorId}/estado")
    public ResponseEntity<ContenedorResponse> updateEstadoContenedor(
            @PathVariable Integer contenedorId,
            @RequestBody EstadoUpdateRequest request
    ) {
        service.updateEstadoContenedor(contenedorId, request);
        return ResponseEntity.accepted().build();
    }
    
    
}
