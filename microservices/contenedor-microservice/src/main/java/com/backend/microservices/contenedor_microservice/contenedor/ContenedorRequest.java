package com.backend.microservices.contenedor_microservice.contenedor;

import jakarta.validation.constraints.NotNull;

public record ContenedorRequest(

    @NotNull(message = "El peso no puede ser nulo.")
    Double peso,

    @NotNull(message = "El volumen no puede ser nulo.")
    Double volumen,
    
    @NotNull(message = "El ID delcliente no puede ser nulo.")
    Integer clienteId,
    
    @NotNull(message = "El ID de Geolocalizacion no puede ser nulo.")
    Integer geolocalizacionId,

    Integer estadoId
) {

}
