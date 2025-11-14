package com.backend.microservices.solicitud_microservice.cambio_estado;

import org.springframework.stereotype.Service;

import com.backend.microservices.solicitud_microservice.estado.Estado;
import com.backend.microservices.solicitud_microservice.estado.EstadoMapper;
import com.backend.microservices.solicitud_microservice.solicitud.Solicitud;
import com.backend.microservices.solicitud_microservice.solicitud.SolicitudMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CambioEstadoMapper {

    private final EstadoMapper estadoMapper;
    private final SolicitudMapper solicitudMapper;

    // 🔹 Crear entidad CambioEstado desde el service (fechas vienen desde el service)
    public CambioEstado toCambioEstado(Estado estado, Solicitud solicitud) {
        CambioEstado cambio = new CambioEstado();
        cambio.setEstado(estado);
        cambio.setSolicitud(solicitud);
        return cambio;
    }

    // 🔹 Para devolver al cliente
    public CambioEstadoResponse toResponse(CambioEstado cambio) {
        return new CambioEstadoResponse(
                cambio.getNroOrdenId(),
                estadoMapper.toResponse(cambio.getEstado()),
                solicitudMapper.toResponse(cambio.getSolicitud()),
                cambio.getFechaDesde(),
                cambio.getFechaHasta()
        );
    }
}
