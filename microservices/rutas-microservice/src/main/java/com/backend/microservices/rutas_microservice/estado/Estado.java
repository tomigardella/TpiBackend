package com.backend.microservices.rutas_microservice.estado;

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
@Table(name = "estados")
public class Estado {

    @Id
    @GeneratedValue
    private Integer estadoId;

    private String nombre;
    private String descripcion;
    private Boolean activo;
    private String ambito;
}
