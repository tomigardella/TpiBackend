package com.backend.microservices.solicitud_microservice.cambio_estado;

import java.sql.Timestamp;

import com.backend.microservices.solicitud_microservice.estado.EstadoResponse;
import com.backend.microservices.solicitud_microservice.solicitud.SolicitudResponse;

public record CambioEstadoResponse(
    Integer nroOrdenId,
    EstadoResponse estado,
    SolicitudResponse solicitud,
    Timestamp fechaDesde,
    Timestamp fechaHasta
) {
    
}
