package com.backend.microservices.contenedor_microservice.contenedor;

import com.backend.microservices.contenedor_microservice.estado.Estado;

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
@Table(name = "contenedores")
public class Contenedor {
    @Id
    @GeneratedValue
    private Integer contenedorId;

    private Double pesoKg;
    private Double volumenM3;

    @ManyToOne
    @JoinColumn(name = "estado_id")
    private Estado estado;

    private Integer clienteId;

    private Integer geolocalizacionId;

}
