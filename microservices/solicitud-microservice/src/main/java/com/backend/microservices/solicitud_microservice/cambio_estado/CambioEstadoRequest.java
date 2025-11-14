package com.backend.microservices.solicitud_microservice.cambio_estado;

import java.sql.Timestamp;

import jakarta.validation.constraints.NotNull;

public record CambioEstadoRequest(

    @NotNull(message = "El estado no puede ser nulo")
    Integer estadoId,

    @NotNull(message = "La solicitud no puede ser nula")
    Integer solicitudId,

    @NotNull(message = "La fecha desde no puede ser nula")
    Timestamp fechaDesde,

    Timestamp fechaHasta
) {

}
