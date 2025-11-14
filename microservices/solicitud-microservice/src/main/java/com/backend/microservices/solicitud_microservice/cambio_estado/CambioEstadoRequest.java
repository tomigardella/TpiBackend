package com.backend.microservices.solicitud_microservice.cambio_estado;

import java.sql.Timestamp;

import jakarta.validation.constraints.NotNull;

public record CambioEstadoRequest(

    @NotNull(message = "El estado no puede ser nulo")
    Integer estadoId
) {

}
