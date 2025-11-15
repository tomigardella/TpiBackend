package com.backend.microservices.rutas_microservice.tipo_tramo;

import org.springframework.stereotype.Service;

@Service
public class TipoTramoMapper {

    public TipoTramo toTipoTramo(TipoTramoRequest request) {
        return TipoTramo.builder()
                .descripcion(request.descripcion())
                .build();
    }

    public TipoTramoResponse toResponse(TipoTramo tipoTramo) {
        return new TipoTramoResponse(
                tipoTramo.getTipoTramoId(),
                tipoTramo.getDescripcion()
        );
    }
}
