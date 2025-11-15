package com.backend.microservices.rutas_microservice.ruta;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
@Table(name = "rutas")
public class Ruta {
    @Id
    @GeneratedValue
    private Integer rutaId;

    private Integer cantidadTramos;
    private Integer cantidadDepositos;
    private Double distanciaTotalKm;
    private Timestamp fechaCreacion;
    private Integer solicitudId;
}
