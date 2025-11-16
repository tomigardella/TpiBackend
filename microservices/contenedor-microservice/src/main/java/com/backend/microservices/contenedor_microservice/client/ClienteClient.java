package com.backend.microservices.contenedor_microservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "solicitud-microservice")
public interface ClienteClient {
    @GetMapping("/api/clientes/{clienteId}")
    ClienteResponse getClienteById(@PathVariable("clienteId") Integer clienteId);
}
