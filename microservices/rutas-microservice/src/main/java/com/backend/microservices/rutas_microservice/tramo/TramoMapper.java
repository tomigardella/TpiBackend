package com.backend.microservices.rutas_microservice.tramo;

import org.springframework.stereotype.Service;

import com.backend.microservices.rutas_microservice.estado.EstadoMapper;
import com.backend.microservices.rutas_microservice.ruta.Ruta;
import com.backend.microservices.rutas_microservice.ruta.RutaMapper;
import com.backend.microservices.rutas_microservice.tipo_tramo.TipoTramo;
import com.backend.microservices.rutas_microservice.tipo_tramo.TipoTramoMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TramoMapper {

    private final TipoTramoMapper tipoTramoMapper;
    private final EstadoMapper estadoMapper;
    private final RutaMapper rutaMapper;


    public Tramo toTramo(TramoRequest request, Ruta ruta, TipoTramo tipoTramo) {
        return Tramo.builder()
                .ruta(ruta)
                .tipoTramo(tipoTramo)
                .depositoOrigenId(request.depositoOrigenId())
                .depositoDestinoId(request.depositoDestinoId())
                .costoAproximado(request.costoAproximado())
                .build();
    }

    public TramoResponse toResponse(Tramo tramo) {
        return new TramoResponse(
            tramo.getTramoId(),
            tramo.getRuta() != null ? rutaMapper.toResponse(tramo.getRuta()) : null,
            tramo.getTipoTramo() != null ? tipoTramoMapper.toResponse(tramo.getTipoTramo()) : null,
            tramo.getEstado() != null ? estadoMapper.toResponse(tramo.getEstado()) : null,
            tramo.getDepositoOrigenId(),
            tramo.getDepositoDestinoId(),
            tramo.getCostoAproximado(),
            tramo.getCostoReal(),
            tramo.getFechaHoraInicio(),
            tramo.getFechaHoraFin(),
            tramo.getCamionId()
        );
    }

}
