package com.backend.microservices.solicitud_microservice.solicitud;

import java.sql.Timestamp;

import com.backend.microservices.solicitud_microservice.cliente.Cliente;
import com.backend.microservices.solicitud_microservice.estado.Estado;
import com.backend.microservices.solicitud_microservice.tarifa.Tarifa;

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
@Table(name="solicitudes")
public class Solicitud {
    @Id
    @GeneratedValue
    private Integer solicitudId;

    private Integer contenedorId;
    private Integer origenId;
    private Integer destinoId;
    private String direccionOrigen;
    private String direccionDestino;
    private Double costoEstimado;
    private Integer tiempoEstimado;
    private Timestamp tiempoReal;
    private Timestamp fechaSolicitud;
    private Double costoFinal;

    @ManyToOne
    @JoinColumn(name = "tarifa_id")
    private Tarifa tarifa;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "estado_id")
    private Estado estadoActual;
}
