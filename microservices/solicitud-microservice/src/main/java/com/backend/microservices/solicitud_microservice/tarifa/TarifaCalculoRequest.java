package com.backend.microservices.solicitud_microservice.tarifa;

import jakarta.validation.constraints.NotNull;

public record TarifaCalculoRequest(
    @NotNull(message = "La distancia total no puede ser nula")
    Double distanciaTotalKM,

    @NotNull(message = "El peso no puede ser nulo")
    Double peso,

    @NotNull(message = "El volumen no puede ser nul")
    Double volumen
) {

}
