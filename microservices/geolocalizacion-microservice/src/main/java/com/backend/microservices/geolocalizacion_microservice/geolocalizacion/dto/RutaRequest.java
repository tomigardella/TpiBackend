package com.backend.microservices.geolocalizacion_microservice.geolocalizacion.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RutaRequest {
    private double lat_origen;
    private double lng_origen;
    private double lat_destino;
    private double lng_destino;
}