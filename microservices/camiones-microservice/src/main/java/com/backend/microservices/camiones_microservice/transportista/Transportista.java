package com.backend.microservices.camiones_microservice.transportista;

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
@Table(name = "transportistas")
public class Transportista {
    @Id
    @GeneratedValue
    private Integer transportistaId;
    
    private String nombre;
    private String tipoDocumento;
    private String nroDocumento;
    private String telefono;
    private String email;
    private String empresa;
}
