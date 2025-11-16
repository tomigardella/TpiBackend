package com.backend.microservices.depositos_microservice.deposito;

import jakarta.validation.constraints.NotNull;

public record DepositoRequest(

    @NotNull(message = "El nombre no puede ser nulo")
    String nombre,
    
    @NotNull(message = "La direccion no puede ser nula")
    String direccion,
    
    @NotNull(message = "La capacidad de peso no puede ser nula")
    Double capacidadPesoKg,
    
    @NotNull(message = "La capacidad de volumen no puede ser nula")
    Double capacidadVolumenM3,
    
    @NotNull(message = "El costo por día no puede ser nulo")
    Double costoDia
    
) {

}
