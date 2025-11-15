package com.backend.microservices.rutas_microservice.tramo;

import java.sql.Timestamp;

import com.backend.microservices.rutas_microservice.estado.Estado;
import com.backend.microservices.rutas_microservice.ruta.Ruta;
import com.backend.microservices.rutas_microservice.tipo_tramo.TipoTramo;

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
@Table(name = "tramos")
public class Tramo {
    @Id
    @GeneratedValue
    private Integer tramoId;

    @ManyToOne
    @JoinColumn(name = "ruta_id")
    private Ruta ruta;

    @ManyToOne
    @JoinColumn(name = "tipo_tramo_id")
    private TipoTramo tipoTramo;

    @ManyToOne
    @JoinColumn(name = "estado_id")
    private Estado estado;

    private Integer depositoOrigenId;
    private Integer depositoDestinoId;
    private Double costoAproximado;
    private Double costoReal;
    private Timestamp fechaHoraInicio;
    private Timestamp fechaHoraFin;
    
    private Integer camionId;
}
