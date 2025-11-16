package com.backend.microservices.depositos_microservice.deposito;

import org.springframework.stereotype.Service;

@Service
public class DepositoMapper {

    public DepositoResponse toResponse(Deposito deposito) {
        return new DepositoResponse(
            deposito.getDepositoId(),
            deposito.getNombre(),
            deposito.getDireccion(),
            deposito.getCapacidadPesoKg(),
            deposito.getCapacidadVolumenM3(),
            deposito.getCostoDia()
        );
    }

    public Deposito toDeposito(DepositoRequest request) {
        return Deposito.builder()
            .direccion(request.direccion())
            .capacidadPesoKg(request.capacidadPesoKg())
            .capacidadVolumenM3(request.capacidadVolumenM3())
            .costoDia(request.costoDia())
            .build();
    }
}
