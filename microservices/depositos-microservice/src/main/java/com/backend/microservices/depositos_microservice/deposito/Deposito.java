package com.backend.microservices.depositos_microservice.deposito;

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
public class Deposito {
    @Id
    @GeneratedValue
    private Integer depositoId;

    private String nombre;
    private String direccion;
    private Double capacidadPesoKg;
    private Double capacidadVolumenM3;
    private Double costoDia;

    private Integer geolocalizacionId;
}
