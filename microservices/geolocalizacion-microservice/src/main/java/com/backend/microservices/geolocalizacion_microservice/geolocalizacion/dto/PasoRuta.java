package com.backend.microservices.geolocalizacion_microservice.geolocalizacion.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PasoRuta {
    private String instruccion;
    private double distancia_m;
    private double duracion_min;
}