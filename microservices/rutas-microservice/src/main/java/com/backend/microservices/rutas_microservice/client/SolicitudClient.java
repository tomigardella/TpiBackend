package com.backend.microservices.rutas_microservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "solicitud-microservice")
public interface SolicitudClient {

    @GetMapping("/api/solicitudes/{solicitudId}")
    SolicitudResponse getSolicitudById(@PathVariable("solicitudId") Integer solicitudId);
}
