package com.backend.microservices.camiones_microservice.exceptions;


import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.backend.microservices.common_exceptions.ErrorResponse;
import com.backend.microservices.common_exceptions.GlobalExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice(basePackages = "com.backend.microservices.camiones_microservice") 
@Primary
@Slf4j
public class CamionesExceptionHandler extends GlobalExceptionHandler {

    @ExceptionHandler(TransportistaException.class)
    public ResponseEntity<ErrorResponse> handle (TransportistaException exception)
    {
      
        var errors = new HashMap<String, String>();
        var fieldName = "camiones-service";
        errors.put(fieldName, exception.getMessage());

        log.warn("Transportista error: {}", exception.toString());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(errors)); 

    }

    @ExceptionHandler(CamionException.class)
    public ResponseEntity<ErrorResponse> handle (CamionException exception)
    {
      
        var errors = new HashMap<String, String>();
        var fieldName = "camiones-service";
        errors.put(fieldName, exception.getMessage());

        log.warn("Camion error: {}", exception.toString());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(errors)); 

    } 
    
}
