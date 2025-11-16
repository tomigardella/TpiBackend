package com.backend.microservices.depositos_microservice.estadiaDeposito;
import org.springframework.stereotype.Service;

@Service
public class EstadiaDepositoMapper {

    public EstadiaDepositoResponse toResponse(EstadiaDeposito estadiaDeposito) {
        return new EstadiaDepositoResponse(
            estadiaDeposito.getEstadiaDepositoID(),
            estadiaDeposito.getFechaEntrada(),
            estadiaDeposito.getFechaSalida(),
            estadiaDeposito.getDiasEstadia(),
            estadiaDeposito.getContenedorId()
        );
    }

    public EstadiaDeposito toEstadiaDeposito(EstadiaDepositoRequest request) {
        return EstadiaDeposito.builder()
            .fechaEntrada(request.fechaEntrada())
            .fechaSalida(request.fechaSalida())
            .diasEstadia(request.diasEstadia())
            .contenedorId(request.contenedorId())
            .build();
    }
}
