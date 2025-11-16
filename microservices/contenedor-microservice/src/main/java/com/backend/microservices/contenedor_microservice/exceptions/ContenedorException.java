package com.backend.microservices.contenedor_microservice.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ContenedorException extends RuntimeException {
    private final String message;
}
