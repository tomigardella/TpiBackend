package com.backend.microservices.rutas_microservice.estado;

import jakarta.validation.constraints.NotNull;

public record EstadoRequest(

    @NotNull(message = "El nombre no puede ser nulo")
    String nombre,

    @NotNull(message = "La descripcion no puede ser nula")
    String descripcion,

    Boolean activo,

    @NotNull(message = "El ambito no puede ser nulo")
    String ambito
) {

}
