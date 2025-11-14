package com.backend.microservices.solicitud_microservice.cambio_estado;

import org.springframework.stereotype.Service;

import com.backend.microservices.solicitud_microservice.estado.Estado;
import com.backend.microservices.solicitud_microservice.estado.EstadoMapper;
import com.backend.microservices.solicitud_microservice.solicitud.SolicitudMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CambioEstadoMapper {

    private final EstadoMapper estadoMapper;
    private final SolicitudMapper solicitudMapper;

    public CambioEstado toCambioEstado(CambioEstadoRequest request, Estado estado, com.backend.microservices.solicitud_microservice.solicitud.Solicitud solicitud) {
        return new CambioEstado(
            null,
            estado,
            solicitud,
            request.fechaDesde(),
            request.fechaHasta()
        );
    }

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
