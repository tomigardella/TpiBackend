package com.backend.microservices.contenedor_microservice.contenedor;

import com.backend.microservices.contenedor_microservice.estado.EstadoResponse;

public record ContenedorResponse(
    Integer contenedorId,
    Double peso,
    Double volumen,
    Integer clienteId,
    Integer geolocalizacionId,
    EstadoResponse estado
) {

}
