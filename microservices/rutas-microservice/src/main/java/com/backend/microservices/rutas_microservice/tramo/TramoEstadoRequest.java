package com.backend.microservices.rutas_microservice.tramo;

import jakarta.validation.constraints.NotNull;

public record TramoEstadoRequest(
    @NotNull(message = "El ID del ESTADO no puede ser nulo.")
    Integer estadoId
) {

}
