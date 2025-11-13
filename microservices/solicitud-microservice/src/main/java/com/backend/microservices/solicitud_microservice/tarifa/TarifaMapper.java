package com.backend.microservices.solicitud_microservice.tarifa;

import org.springframework.stereotype.Service;

@Service
public class TarifaMapper {

    public Tarifa toTarifa(TarifaRequest request) {
        return Tarifa.builder()
                .tarifaId(request.tarifaId())
                .rangoPesoMinKg(request.rangoPesoMinKg())
                .rangoPesoMaxKg(request.rangoPesoMaxKg())
                .rangoVolMinM3(request.rangoVolMinM3())
                .rangoVolMaxM3(request.rangoVolMaxM3())
                .costoKmBase(request.costoKmBase())
                .cargoGestionPorTramo(request.cargoGestionPorTramo())
                .build();
    }

    public TarifaResponse toResponse(Tarifa tarifa) {
        return new TarifaResponse(
                tarifa.getTarifaId(),
                tarifa.getRangoPesoMinKg(),
                tarifa.getRangoPesoMaxKg(),
                tarifa.getRangoVolMinM3(),
                tarifa.getRangoVolMaxM3(),
                tarifa.getCostoKmBase(),
                tarifa.getCargoGestionPorTramo()
        );
    }
}
