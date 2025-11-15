package com.backend.microservices.camiones_microservice.camion;

import com.backend.microservices.camiones_microservice.transportista.Transportista;

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
@Table(name = "camiones")
public class Camion {
    @Id
    @GeneratedValue
    private Integer camionId;

    private String patente;
    private String marca;
    private String modelo;
    private Double capacidadPesoKg;
    private Double capacidadVolumenM3;
    private Double consumoPorKm;
    private Double costoBasePorKm;
    private boolean disponible;

    @ManyToOne
    @JoinColumn(name = "transportista_id")
    private Transportista transportista;
}
