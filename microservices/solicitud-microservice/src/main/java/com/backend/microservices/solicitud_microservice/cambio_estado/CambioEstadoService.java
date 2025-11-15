package com.backend.microservices.solicitud_microservice.cambio_estado;

import java.util.List;

import org.springframework.stereotype.Service;

import com.backend.microservices.solicitud_microservice.exceptions.SolicitudException;
import com.backend.microservices.solicitud_microservice.solicitud.Solicitud;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CambioEstadoService {

    private final CambioEstadoRepository repository;
    private final CambioEstadoMapper mapper;

    // Obtener todos los cambios de estado
    public List<CambioEstadoResponse> getAllCambios() {
        return repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    // Obtener cambio por ID
    public CambioEstadoResponse getById(Integer id) {
        return repository.findById(id)
            .map(mapper::toResponse)
            .orElseThrow(() -> new SolicitudException("Cambio de estado no encontrado"));
    }

    // Buscar el último cambio de estado de una solicitud
    public CambioEstado getUltimoCambio(Integer solicitudId) {
        var solicitud = new Solicitud();
        solicitud.setSolicitudId(solicitudId);

        CambioEstado ultimo = repository.findTopBySolicitudOrderByFechaDesdeDesc(solicitud);

        return ultimo;
    }
}

