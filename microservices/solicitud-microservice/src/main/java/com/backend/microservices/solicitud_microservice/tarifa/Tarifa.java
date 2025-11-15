package com.backend.microservices.solicitud_microservice.tarifa;

import java.util.ArrayList;
import java.util.List;

import com.backend.microservices.solicitud_microservice.solicitud.Solicitud;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
@Table(name="tarifas")
public class Tarifa {

    @Id
    @GeneratedValue
    private Integer tarifaId;
    
    private Double rangoPesoMinKg;
    private Double rangoPesoMaxKg;
    private Double rangoVolMinM3;
    private Double rangoVolMaxM3;
    private Double costoKmBase;
    private Double cargoGestionPorTramo;

    @OneToMany(mappedBy = "tarifa")
    private List<Solicitud> solicitudes = new ArrayList<>();

}
