package com.backend.microservices.camiones_microservice.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class TransportistaException extends RuntimeException {
    private final String message;
}
