package com.backend.microservices.camiones_microservice.camion;

import java.util.List;

import org.springframework.stereotype.Service;

import com.backend.microservices.camiones_microservice.exceptions.CamionException;
import com.backend.microservices.camiones_microservice.exceptions.TransportistaException;
import com.backend.microservices.camiones_microservice.transportista.Transportista;
import com.backend.microservices.camiones_microservice.transportista.TransportistaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CamionService {

    private final CamionRepository camionRepository;
    private final CamionMapper mapper;
    private final TransportistaRepository transportistaRepository;

    public List<CamionResponse> getAllCamiones() {
        return camionRepository
                .findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    public Integer createCamion(CamionRequest request) {
        Transportista transportista = transportistaRepository.findById(request.transportistaId())
            .orElseThrow(() -> new TransportistaException("Transportista no encontrado"));

        Camion camion = mapper.toCamion(request, transportista);
        camionRepository.save(camion);
        return camion.getCamionId();
    }

    public void deleteCamion(Integer id) {
        if (!camionRepository.existsById(id)) {
            throw new CamionException("Camion no encontrado con id: " + id);
        }
        camionRepository.deleteById(id);
    }

    public void updateCamion(Integer camionId, CamionRequest request) {
        Camion camion = camionRepository.findById(camionId)
            .orElseThrow(() -> new CamionException("Camion no encontrado"));

        Transportista transportista = transportistaRepository.findById(request.transportistaId())
            .orElseThrow(() -> new TransportistaException("Transportista no encontrado"));
        
        camion.setPatente(request.patente());
        camion.setMarca(request.marca());
        camion.setModelo(request.modelo());
        camion.setCapacidadPesoKg(request.capacidadPesoKg());
        camion.setCapacidadVolumenM3(request.capacidadVolumenM3());
        camion.setConsumoPorKm(request.consumoPorKm());
        camion.setCostoBasePorKm(request.costoBasePorKm());
        camion.setDisponible(request.disponible());
        camion.setTransportista(transportista);

        camionRepository.save(camion);
    }

    public List<CamionResponse> getCamionesDisponibles() {
        return camionRepository
                .findByDisponibleTrue()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }
}
