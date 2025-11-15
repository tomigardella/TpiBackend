package com.backend.microservices.rutas_microservice.client;

public record SolicitudResponse(
        Integer solicitudId,
        String origen,
        String destino,
        String descripcion,
        String estado
) {}
