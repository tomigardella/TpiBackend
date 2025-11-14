package com.backend.microservices.camiones_microservice.camion;

import com.backend.microservices.camiones_microservice.transportista.TransportistaResponse;

public record CamionResponse(
    Integer camionId,
    String patente,
    String marca,
    String modelo,
    Double capacidadPesoKg,
    Double capacidadVolumenM3,
    Double consumoPorKm,
    Double costoBasePorKm,
    boolean disponible,
    TransportistaResponse transportista
) {

}
