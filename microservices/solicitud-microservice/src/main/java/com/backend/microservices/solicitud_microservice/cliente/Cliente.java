package com.backend.microservices.solicitud_microservice.cliente;

import java.util.ArrayList;
import java.util.List;

import com.backend.microservices.solicitud_microservice.solicitud.Solicitud;

import jakarta.persistence.CascadeType;
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
@Table(name="clientes")
public class Cliente {
    @Id
    @GeneratedValue
    private Integer clienteId;

    private String nombre;
    private String apellido;
    private String tipoDocumento;
    private String nroDocumento;
    private String telefono;
    private String email;
    private String direccion;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Solicitud> solicitudes = new ArrayList<>();

}
