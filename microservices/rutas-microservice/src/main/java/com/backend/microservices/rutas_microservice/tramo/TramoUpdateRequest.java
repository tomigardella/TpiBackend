package com.backend.microservices.rutas_microservice.tramo;

import jakarta.validation.constraints.NotNull;

public record TramoUpdateRequest(
    @NotNull(message = "El ID del CAMION no puede ser nulo.")
    Integer camionId
) {

}
