package com.backend.microservices.contenedor_microservice.client;

public record GeolocalizacionResponse( 
    Integer geolocalizacionId,
    Double latitud,
    Double longitud,
    String descripcion) {}

