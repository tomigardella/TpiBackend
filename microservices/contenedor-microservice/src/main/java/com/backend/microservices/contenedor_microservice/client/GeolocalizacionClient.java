package com.backend.microservices.contenedor_microservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "geolocalizacion-microservice")
public interface GeolocalizacionClient {

    @GetMapping("/api/geolocalizaciones/{geolocalizacionId}")
    GeolocalizacionResponse getGeolocalizacionById(@PathVariable("geolocalizacionId") Integer geolocalizacionId);
}  
