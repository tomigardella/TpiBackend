package com.backend.microservices.solicitud_microservice.tarifa;

public record TarifaResponse (
    Integer tarifaId,
    Double rangoPesoMinKg,
    Double rangoPesoMaxKg,
    Double rangoVolMinM3,
    Double rangoVolMaxM3,
    Double costoKmBase,
    Double cargoGestionPorTramo 
    ) {
        
    }
