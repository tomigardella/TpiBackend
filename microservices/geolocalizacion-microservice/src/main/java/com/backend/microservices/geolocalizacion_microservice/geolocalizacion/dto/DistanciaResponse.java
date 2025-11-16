package com.backend.microservices.geolocalizacion_microservice.geolocalizacion.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DistanciaResponse {
    private double distancia_km;
    private double duracion_min;
}