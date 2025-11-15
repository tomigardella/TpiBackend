package com.backend.microservices.camiones_microservice.camion;

public record CamionRequest(
    String patente,
    String marca,
    String modelo,
    Double capacidadPesoKg,
    Double capacidadVolumenM3,
    Double consumoPorKm,
    Double costoBasePorKm,
    boolean disponible,
    Integer transportistaId
) {

}
