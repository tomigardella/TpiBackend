package com.backend.microservices.solicitud_microservice.cambio_estado;

import java.sql.Timestamp;

import com.backend.microservices.solicitud_microservice.estado.Estado;
import com.backend.microservices.solicitud_microservice.solicitud.Solicitud;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "cambios_estado")
public class CambioEstado {
    @Id
    @GeneratedValue
    private Integer nroOrdenId;

    @ManyToOne
    @JoinColumn(name = "estado_id", nullable = false)
    private Estado estado;

    @ManyToOne
    @JoinColumn(name = "solicitud_id", nullable = false)
    private Solicitud solicitud;

    private Timestamp fechaDesde;

    private Timestamp fechaHasta;

}
