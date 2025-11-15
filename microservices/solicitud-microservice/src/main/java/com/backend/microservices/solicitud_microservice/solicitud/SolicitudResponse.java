package com.backend.microservices.solicitud_microservice.solicitud;

import java.sql.Timestamp;

import com.backend.microservices.solicitud_microservice.cliente.ClienteResponse;
import com.backend.microservices.solicitud_microservice.estado.EstadoResponse;
import com.backend.microservices.solicitud_microservice.tarifa.TarifaResponse;

public record SolicitudResponse(
    Integer solicitudId,
    Integer contenedorId,
    Integer origenId,
    Integer destinoId,
    String direccionOrigen,
    String direccionDestino,
    Double costoEstimado,
    Integer tiempoEstimado,
    Timestamp tiempoReal,
    Timestamp fechaSolicitud,
    Double costoFinal,
    ClienteResponse cliente,
    TarifaResponse tarifa,
    EstadoResponse estadoActual
) {}

