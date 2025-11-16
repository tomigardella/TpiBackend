package com.backend.microservices.depositos_microservice.estadiaDeposito;

import java.sql.Timestamp;

import jakarta.validation.constraints.NotNull;

public record EstadiaDepositoRequest(

    @NotNull(message = "El nombre no puede ser nulo")
    Timestamp fechaEntrada,
    
    @NotNull(message = "La direccion no puede ser nula")
    Timestamp fechaSalida,
    
    @NotNull(message = "La capacidad de peso no puede ser nula")
    Integer diasEstadia,

    @NotNull(message = "El ID del contenedor no puede ser nulo")
    Integer contenedorId

    
)
    {
    
    }