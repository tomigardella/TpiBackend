package com.backend.microservices.rutas_microservice.tipo_tramo;

import jakarta.validation.constraints.NotNull;

public record TipoTramoRequest(
    @NotNull String descripcion

) {

}
