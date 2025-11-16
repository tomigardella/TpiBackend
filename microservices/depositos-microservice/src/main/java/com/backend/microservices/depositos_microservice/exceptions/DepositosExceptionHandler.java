package com.backend.microservices.depositos_microservice.exceptions;


import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.backend.microservices.common_exceptions.ErrorResponse;
import com.backend.microservices.common_exceptions.GlobalExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice(basePackages = "com.backend.microservices.depositos_microservice") 
@Primary
@Slf4j
public class DepositosExceptionHandler extends GlobalExceptionHandler {

    @ExceptionHandler(EstadiaDepositoException.class)
    public ResponseEntity<ErrorResponse> handle (EstadiaDepositoException exception)
    {

        var errors = new HashMap<String, String>();
        var fieldName = "depositos-service";
        errors.put(fieldName, exception.getMessage());

        log.warn("EstadiaDeposito error: {}", exception.toString());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(errors)); 

    }

    @ExceptionHandler(DepositoException.class)
    public ResponseEntity<ErrorResponse> handle (DepositoException exception)
    {

        var errors = new HashMap<String, String>();
        var fieldName = "depositos-service";
        errors.put(fieldName, exception.getMessage());

        log.warn("Deposito error: {}", exception.toString());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(errors)); 

    } 
    
}
