package com.backend.microservices.depositos_microservice.estadiaDeposito;

import java.sql.Timestamp;

public record EstadiaDepositoResponse(
    Integer estadiaDepositoId,
    Timestamp fechaEntrada,
    Timestamp fechaSalida,
    Integer diasEstadia,
    Integer contenedorId

) {

}
