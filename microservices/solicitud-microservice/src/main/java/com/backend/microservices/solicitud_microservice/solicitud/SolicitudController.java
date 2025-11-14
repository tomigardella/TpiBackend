package com.backend.microservices.solicitud_microservice.solicitud;

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

import com.backend.microservices.solicitud_microservice.cambio_estado.CambioEstadoRequest;
import com.backend.microservices.solicitud_microservice.tarifa.TarifaRequest;
import com.backend.microservices.solicitud_microservice.tarifa.TarifaResponse;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/solicitudes")
@RequiredArgsConstructor
public class SolicitudController {

    private final SolicitudService service;


    // GET SOLICITUDES
    @GetMapping()
    public ResponseEntity<List<SolicitudResponse>> getAllSolicitudes() {
        return ResponseEntity.ok(service.getAllSolicitudes());
    }

    // POST SOLICITUD
    @PostMapping()
    public ResponseEntity<Integer> createSolicitud(@Valid @RequestBody SolicitudRequest request) {
        return ResponseEntity.ok(service.createSolicitud(request));
    }

    // DELETE SOLICITUD
    @DeleteMapping("/{solicitudId}")
    public ResponseEntity<Void> deleteSolicitud(@PathVariable("solicitudId") Integer id) throws Exception {
        
        service.deleteSolicitud(id);
        return ResponseEntity.noContent().build();
    }

    // ACTUALIZAR SOLICITUD
    @PutMapping("/{solicitudId}")
    public ResponseEntity<Void> updateSolicitud(
            @PathVariable Integer solicitudId,
            @Valid @RequestBody SolicitudRequest request) {

        service.updateSolicitud(solicitudId, request);
        return ResponseEntity.accepted().build();
    }

    @GetMapping("/{solicitudId}")
    public ResponseEntity<SolicitudResponse> getSolicitudById(@PathVariable("solicitudId") Integer solicitudId) {
        return ResponseEntity.ok(service.getSolicitudById(solicitudId));
    }


    // Actualizo el estado actual de la solicitud
    @PutMapping("/{solicitudId}/estado")
    public ResponseEntity<Void> cambiarEstado(
            @PathVariable("solicitudId") Integer solicitudId,
            @Valid @RequestBody CambioEstadoRequest request) {

        service.cambiarEstadoSolicitud(solicitudId, request);
        return ResponseEntity.ok().build();
    }
}
