package com.backend.microservices.contenedor_microservice.estado;

public record EstadoResponse(
    Integer estadoId,
    String nombre,
    String descripcion,
    Boolean activo,
    String ambito
) {

}
