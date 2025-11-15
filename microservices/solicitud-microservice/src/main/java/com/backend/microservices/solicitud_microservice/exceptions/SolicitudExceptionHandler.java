package com.backend.microservices.solicitud_microservice.exceptions;


import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.backend.microservices.common_exceptions.ErrorResponse;
import com.backend.microservices.common_exceptions.GlobalExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice(basePackages = "com.backend.microservices.solicitud_microservice") 
@Primary
@Slf4j
public class SolicitudExceptionHandler extends GlobalExceptionHandler {

    @ExceptionHandler(TarifaException.class)
    public ResponseEntity<ErrorResponse> handle (TarifaException exception)
    {
      
        var errors = new HashMap<String, String>();
        var fieldName = "solicitud-service";
        errors.put(fieldName, exception.getMessage());

        log.warn("Tarifa error: {}", exception.toString());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(errors)); 

    }

    @ExceptionHandler(EstadoException.class)
    public ResponseEntity<ErrorResponse> handle (EstadoException exception)
    {
      
        var errors = new HashMap<String, String>();
        var fieldName = "solicitud-service";
        errors.put(fieldName, exception.getMessage());

        log.warn("Estado error: {}", exception.toString());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(errors)); 

    } 
    
    @ExceptionHandler(ClienteException.class)
    public ResponseEntity<ErrorResponse> handle (ClienteException exception)
    {
      
        var errors = new HashMap<String, String>();
        var fieldName = "solicitud-service";
        errors.put(fieldName, exception.getMessage());

        log.warn("Cliente error: {}", exception.toString());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(errors)); 

    }  
    
    @ExceptionHandler(SolicitudException.class)
    public ResponseEntity<ErrorResponse> handle (SolicitudException exception)
    {
      
        var errors = new HashMap<String, String>();
        var fieldName = "solicitud-service";
        errors.put(fieldName, exception.getMessage());

        log.warn("Solicitud error: {}", exception.toString());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(errors)); 

    } 
}
