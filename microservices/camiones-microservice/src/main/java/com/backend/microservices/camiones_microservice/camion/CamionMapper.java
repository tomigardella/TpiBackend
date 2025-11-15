package com.backend.microservices.camiones_microservice.camion;

import com.backend.microservices.camiones_microservice.transportista.Transportista;
import com.backend.microservices.camiones_microservice.transportista.TransportistaMapper;
import org.springframework.stereotype.Service;

@Service
public class CamionMapper {

    private final TransportistaMapper transportistaMapper;

    CamionMapper(TransportistaMapper transportistaMapper) {
        this.transportistaMapper = transportistaMapper;
    }

    public CamionResponse toResponse(Camion camion) {
        return new CamionResponse(
            camion.getCamionId(),
            camion.getPatente(),
            camion.getMarca(),
            camion.getModelo(),
            camion.getCapacidadPesoKg(),
            camion.getCapacidadVolumenM3(),
            camion.getConsumoPorKm(),
            camion.getCostoBasePorKm(),
            camion.isDisponible(),
            camion.getTransportista() != null ? transportistaMapper.toResponse(camion.getTransportista()) : null
        );
    }

    public Camion toCamion(CamionRequest request, Transportista transportista) {
        return Camion.builder()
            .patente(request.patente())
            .marca(request.marca())
            .modelo(request.modelo())
            .capacidadPesoKg(request.capacidadPesoKg())
            .capacidadVolumenM3(request.capacidadVolumenM3())
            .consumoPorKm(request.consumoPorKm())
            .costoBasePorKm(request.costoBasePorKm())
            .disponible(request.disponible())
            .transportista(transportista)
            .build();
    }
}
