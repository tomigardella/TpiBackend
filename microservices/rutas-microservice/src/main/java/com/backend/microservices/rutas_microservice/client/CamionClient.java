package com.backend.microservices.rutas_microservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "camiones-microservice")
public interface CamionClient {

    @GetMapping("/api/camiones/{camionId}")
    CamionResponse getCamionById(@PathVariable("camionId") Integer camionId);
}
