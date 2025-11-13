package com.backend.microservices.solicitud_microservice.cliente;

import java.util.List;

import jakarta.validation.constraints.NotNull;

public record ClienteRequest(
    Integer clienteId,

    @NotNull(message = "El nombre no puede ser nulo")
    String nombre,

    @NotNull(message = "El apellido no puede ser nulo")
    String apellido,
    
    @NotNull(message = "El tipo de documento no puede ser nulo")
    String tipoDocumento,
    
    @NotNull(message = "El numero de documento no puede ser nulo")
    String nroDocumento,
    
    @NotNull(message = "El telefono no puede ser nulo")
    String telefono,
    
    @NotNull(message = "El email no puede ser nulo")
    String email,
    
    @NotNull(message = "La direccion no puede ser nula")
    String direccion,

    List<Integer> solicitudesIds
) {

}
