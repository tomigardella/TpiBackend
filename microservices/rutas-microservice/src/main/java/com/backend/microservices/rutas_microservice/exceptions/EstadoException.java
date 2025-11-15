package com.backend.microservices.rutas_microservice.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class EstadoException extends RuntimeException {
    private final String message;
}
