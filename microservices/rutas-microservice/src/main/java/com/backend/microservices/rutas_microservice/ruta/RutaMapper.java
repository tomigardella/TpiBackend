package com.backend.microservices.rutas_microservice.ruta;

import org.springframework.stereotype.Service;

@Service
public class RutaMapper {

    public Ruta toRuta(RutaRequest request) {
        return Ruta.builder()
                .cantidadTramos(request.cantidadTramos())
                .cantidadDepositos(request.cantidadDepositos())
                .distanciaTotalKm(request.distanciaTotalKm())
                .fechaCreacion(request.fechaCreacion())
                .solicitudId(request.solicitudId())
                .build();
    }

    public RutaResponse toResponse(Ruta ruta) {
        return new RutaResponse(
                ruta.getRutaId(),
                ruta.getCantidadTramos(),
                ruta.getCantidadDepositos(),
                ruta.getDistanciaTotalKm(),
                ruta.getFechaCreacion(),
                ruta.getSolicitudId()
        );
    }
}
