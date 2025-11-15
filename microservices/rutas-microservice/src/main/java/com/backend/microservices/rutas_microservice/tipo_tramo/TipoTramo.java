package com.backend.microservices.rutas_microservice.tipo_tramo;

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
@Table(name = "tipos_tramo")
public class TipoTramo {
    @Id
    @GeneratedValue
    private Integer tipoTramoId;

    private String descripcion;
}
