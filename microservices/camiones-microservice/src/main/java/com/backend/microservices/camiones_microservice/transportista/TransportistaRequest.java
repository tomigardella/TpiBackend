package com.backend.microservices.camiones_microservice.transportista;

import jakarta.validation.constraints.NotNull;

public record TransportistaRequest(

    @NotNull(message = "El nombre no puede ser nulo")
    String nombre,
    
    @NotNull(message = "El tipo de documento no puede ser nulo")
    String tipoDocumento,
    
    @NotNull(message = "El numero de documento no puede ser nulo")
    String nroDocumento,
    
    @NotNull(message = "El telefono no puede ser nulo")
    String telefono,
    
    @NotNull(message = "El email no puede ser nulo")
    String email,
    
    @NotNull(message = "La empresa no puede ser nula")
    String empresa
) {

}
