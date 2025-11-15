package com.backend.microservices.rutas_microservice.client;

public record CamionResponse(
    Integer camionId,
    String patente,
    String marca,
    String modelo,
    Double capacidadPesoKg,
    Double capacidadVolumenM3,
    Double consumoPorKm,
    Double costoBasePorKm
) {

}
