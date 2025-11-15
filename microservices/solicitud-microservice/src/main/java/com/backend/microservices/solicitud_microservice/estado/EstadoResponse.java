package com.backend.microservices.solicitud_microservice.estado;

public record EstadoResponse(
    Integer estadoId,
    String nombre,
    String descripcion,
    Boolean activo,
    String ambito
) {

}
