package com.backend.microservices.depositos_microservice.estadiaDeposito;

import java.sql.Timestamp;

import com.backend.microservices.depositos_microservice.deposito.Deposito;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "depositos")
public class EstadiaDeposito {
    @Id
    @GeneratedValue
    private Integer estadiaDepositoID;

    private Timestamp fechaEntrada;
    private Timestamp fechaSalida;
    private Integer diasEstadia;

    private Integer contenedorId;

    @ManyToOne
    @JoinColumn(name = "deposito_id")
    private Deposito deposito;
}
