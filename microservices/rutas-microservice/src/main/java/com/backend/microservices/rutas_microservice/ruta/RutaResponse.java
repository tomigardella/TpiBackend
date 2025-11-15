package com.backend.microservices.rutas_microservice.ruta;

import java.sql.Timestamp;

public record RutaResponse(
    Integer rutaId,
    Integer cantidadTramos,
    Integer cantidadDepositos,
    Double distanciaTotalKm,
    Timestamp fechaCreacion,
    Integer solicitudId
) {

}
