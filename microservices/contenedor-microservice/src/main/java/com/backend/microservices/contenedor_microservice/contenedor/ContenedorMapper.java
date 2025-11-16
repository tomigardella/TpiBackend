package com.backend.microservices.contenedor_microservice.contenedor;

import org.springframework.stereotype.Service;

import com.backend.microservices.contenedor_microservice.estado.Estado;
import com.backend.microservices.contenedor_microservice.estado.EstadoMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ContenedorMapper {

    private final EstadoMapper estadoMapper;

    public Contenedor toContenedor(ContenedorRequest request, Estado estado) {
        return Contenedor.builder()
                .pesoKg(request.peso())
                .volumenM3(request.volumen())
                .estado(estado)
                .clienteId(request.clienteId())
                .geolocalizacionId(request.geolocalizacionId())
                .build();
    }

    public ContenedorResponse toResponse(Contenedor contenedor) {
        return new ContenedorResponse(
                contenedor.getContenedorId(),
                contenedor.getPesoKg(),
                contenedor.getVolumenM3(),
                contenedor.getClienteId(),
                contenedor.getGeolocalizacionId(),
                contenedor.getEstado() != null ? estadoMapper.toResponse(contenedor.getEstado()) : null
        );
    }
}
