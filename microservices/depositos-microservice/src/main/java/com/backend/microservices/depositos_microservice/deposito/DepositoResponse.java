package com.backend.microservices.depositos_microservice.deposito;

public record DepositoResponse(
    Integer depositoId,
    String nombre,
    String direccion,
    Double capacidadPesoKg,
    Double capacidadVolumenM3,
    Double costoDia
) {

}
