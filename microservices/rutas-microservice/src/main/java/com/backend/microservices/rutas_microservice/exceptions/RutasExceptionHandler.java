package com.backend.microservices.rutas_microservice.exceptions;


import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.backend.microservices.common_exceptions.ErrorResponse;
import com.backend.microservices.common_exceptions.GlobalExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice(basePackages = "com.backend.microservices.rutas_microservice") 
@Primary
@Slf4j
public class RutasExceptionHandler extends GlobalExceptionHandler {

    @ExceptionHandler(RutaException.class)
    public ResponseEntity<ErrorResponse> handle (RutaException exception)
    {
      
        var errors = new HashMap<String, String>();
        var fieldName = "rutas-service";
        errors.put(fieldName, exception.getMessage());

        log.warn("Ruta error: {}", exception.toString());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(errors)); 

    }

    @ExceptionHandler(EstadoException.class)
    public ResponseEntity<ErrorResponse> handle (EstadoException exception)
    {
      
        var errors = new HashMap<String, String>();
        var fieldName = "rutas-service";
        errors.put(fieldName, exception.getMessage());

        log.warn("Estado error: {}", exception.toString());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(errors)); 

    }

    @ExceptionHandler(TramoException.class)
    public ResponseEntity<ErrorResponse> handle (TramoException exception)
    {
      
        var errors = new HashMap<String, String>();
        var fieldName = "rutas-service";
        errors.put(fieldName, exception.getMessage());

        log.warn("Tramo error: {}", exception.toString());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(errors)); 

    }

    @ExceptionHandler(TipoTramoException.class)
    public ResponseEntity<ErrorResponse> handle (TipoTramoException exception)
    {
      
        var errors = new HashMap<String, String>();
        var fieldName = "rutas-service";
        errors.put(fieldName, exception.getMessage());

        log.warn("Tipo tramo error: {}", exception.toString());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(errors)); 

    }

}
