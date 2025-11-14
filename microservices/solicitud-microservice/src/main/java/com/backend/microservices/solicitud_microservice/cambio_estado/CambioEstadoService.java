package com.backend.microservices.solicitud_microservice.cambio_estado;

import java.util.List;

import org.springframework.stereotype.Service;

import com.backend.microservices.solicitud_microservice.estado.EstadoRepository;
import com.backend.microservices.solicitud_microservice.exceptions.SolicitudException;
import com.backend.microservices.solicitud_microservice.solicitud.SolicitudRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CambioEstadoService {

    private final CambioEstadoRepository repository;
    private final CambioEstadoMapper mapper;
    private final EstadoRepository estadoRepository;
    private final SolicitudRepository solicitudRepository;

    // Obtener todos los cambios de estado
    public List<CambioEstadoResponse> getAllCambios() {
        return repository.findAll()
            .stream()
            .map(mapper::toResponse)
            .toList();
    }

    // Crear nuevo cambio de estado
    public Integer createCambioEstado(CambioEstadoRequest request) {
        var estado = estadoRepository.findById(request.estadoId())
            .orElseThrow(() -> new SolicitudException("Estado no encontrado"));
        var solicitud = solicitudRepository.findById(request.solicitudId())
            .orElseThrow(() -> new SolicitudException("Solicitud no encontrada"));

        CambioEstado cambio = mapper.toCambioEstado(request, estado, solicitud);
        repository.save(cambio);
        return cambio.getNroOrdenId();
    }
}
