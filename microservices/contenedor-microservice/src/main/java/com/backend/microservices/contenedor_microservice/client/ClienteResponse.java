package com.backend.microservices.contenedor_microservice.client;

import java.util.List;

public record ClienteResponse(
    Integer clienteId,
    String nombre,
    String apellido,
    String tipoDocumento,
    String nroDocumento,
    String telefono,
    String email,
    String direccion,
    List<Integer> solicitudesIds
) {

}

