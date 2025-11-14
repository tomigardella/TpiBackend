package com.backend.microservices.solicitud_microservice.cliente;

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

@RestController
@RequestMapping("/api/clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService service;

    @GetMapping()
    public ResponseEntity<List<ClienteResponse>> getAllClientes() {
        return ResponseEntity.ok(service.getAllClientes());
    }

    @PostMapping()
    public ResponseEntity<Integer> createCliente(@Valid @RequestBody ClienteRequest request) {
        return ResponseEntity.ok(service.createCliente(request));
    }

    @DeleteMapping("/{clienteId}")
    public ResponseEntity<Void> deleteCliente(@PathVariable("clienteId") Integer id) throws Exception {
        
        service.deleteCliente(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{clienteId}")
    public ResponseEntity<Void> updateCliente(
            @PathVariable Integer clienteId,
            @Valid @RequestBody ClienteRequest request) {
        service.updateCliente(clienteId, request);
        return ResponseEntity.accepted().build();
    }

    @GetMapping("/{clienteId}")
    public ResponseEntity<ClienteResponse> getClienteById(@PathVariable("clienteId") Integer id) {
        return ResponseEntity.ok(service.getClienteById(id));
    }  

    // @GetMapping("/{clienteId}/solicitudes")
    // public ResponseEntity<List<SolicitudResponse>> getSolicitudesByCliente(@PathVariable Integer clienteId) {
    //     return ResponseEntity.ok(service.getSolicitudesByCliente(clienteId));
    // }

}