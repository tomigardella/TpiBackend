package com.backend.microservices.contenedor_microservice.contenedor;

public record ContenedorUpdateRequest(
    Double peso,
    Double volumen,
    Integer estadoId
) {

}
