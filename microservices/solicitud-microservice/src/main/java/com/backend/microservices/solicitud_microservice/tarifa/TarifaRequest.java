package com.backend.microservices.solicitud_microservice.tarifa;

import jakarta.validation.constraints.NotNull;

public record TarifaRequest(
    Integer tarifaId,
    
    @NotNull(message = "El rango de peso minimo no puede ser nulo")
    Double rangoPesoMinKg,
    
    @NotNull(message = "El rango de peso maximo no puede ser nulo")
    Double rangoPesoMaxKg,
    
    @NotNull(message = "El rango de volumen minimo no puede ser nulo")
    Double rangoVolMinM3,
    
    @NotNull(message = "El rango de volumen maximo no puede ser nulo")
    Double rangoVolMaxM3,
    
    @NotNull(message = "El costo base por KM no puede ser nulo")
    Double costoKmBase,
    
    @NotNull(message = "El cargo por tramo no puede ser nulo")
    Double cargoGestionPorTramo 
) {

}
