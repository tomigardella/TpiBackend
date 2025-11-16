package com.backend.microservices.contenedor_microservice.estado;

import org.springframework.stereotype.Service;

@Service
public class EstadoMapper {

    public Estado toEstado(EstadoRequest request) {
        return Estado.builder()
                .nombre(request.nombre())
                .descripcion(request.descripcion())
                .activo(request.activo())
                .ambito(request.ambito())
                .build();
    }

    public EstadoResponse toResponse(Estado estado) {
        return new EstadoResponse(
                estado.getEstadoId(),
                estado.getNombre(),
                estado.getDescripcion(),
                estado.getActivo(),
                estado.getAmbito()
        );
    }
}
