package com.backend.microservices.solicitud_microservice.estado;

import jakarta.validation.constraints.NotNull;

public record EstadoRequest(
    Integer estadoId,

    @NotNull(message = "El nombre no puede ser nulo")
    String nombre,

    @NotNull(message = "La descripcion no puede ser nula")
    String descripcion,

    Boolean activo,

    @NotNull(message = "El ambito no puede ser nulo")
    String ambito
) {

}
