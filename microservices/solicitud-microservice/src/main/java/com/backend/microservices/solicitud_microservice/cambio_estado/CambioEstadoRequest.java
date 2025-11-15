package com.backend.microservices.solicitud_microservice.cambio_estado;

import jakarta.validation.constraints.NotNull;

public record CambioEstadoRequest(

    @NotNull(message = "El estado no puede ser nulo")
    Integer estadoId
) {

}
