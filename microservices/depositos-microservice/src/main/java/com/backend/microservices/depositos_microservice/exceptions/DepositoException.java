package com.backend.microservices.depositos_microservice.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class DepositoException extends RuntimeException {
    private final String message;
}
