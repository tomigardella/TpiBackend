package com.backend.microservices.contenedor_microservice.contenedor;

import jakarta.validation.constraints.NotNull;

public record EstadoUpdateRequest(
    @NotNull(message = "El ID del estado no puede ser nulo.")
    Integer estadoId
) {

}
