package com.backend.microservices.camiones_microservice.transportista;

public record TransportistaResponse(
    Integer transportistaId,
    String nombre,
    String tipoDocumento,
    String nroDocumento,
    String telefono,
    String email,
    String empresa
) {

}
