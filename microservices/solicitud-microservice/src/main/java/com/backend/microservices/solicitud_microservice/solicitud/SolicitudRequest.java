package com.backend.microservices.solicitud_microservice.solicitud;

import java.sql.Timestamp;

import jakarta.validation.constraints.NotNull;

public record SolicitudRequest(
    Integer solicitudId,
    @NotNull Integer contenedorId,
    @NotNull Integer origenId,
    @NotNull Integer destinoId,
    String direccionOrigen,
    String direccionDestino,
    Double costoEstimado,
    Integer tiempoEstimado,
    String tiempoReal,
    String fechaSolicitud,
    Double costoFinal,
    @NotNull Integer clienteId,
    @NotNull Integer tarifaId,
    @NotNull Integer estadoId
) {}
