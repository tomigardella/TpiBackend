package com.backend.microservices.solicitud_microservice.tarifa;

import java.util.List;

import org.springframework.stereotype.Service;

import com.backend.microservices.solicitud_microservice.exceptions.TarifaException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TarifaService {

    private final TarifaRepository repository;
    private final TarifaMapper mapper;

    public List<TarifaResponse> getAllTarifas() {
        return repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();

    }

    public Integer createTarifa(TarifaRequest request) {
       Tarifa tarifa = mapper.toTarifa(request);
       return repository.save(tarifa).getTarifaId();
    }

    public void deleteTarifa(Integer id) {
        if (id == null) {
            throw new TarifaException("El id de tarifa no puede ser nulo.");
        }
        else if (!repository.existsById(id)) {
            throw new TarifaException("La tarifa con id " + id + " no existe.");
        }
        repository.deleteById(id);
    }

    public Integer updateTarifa(Integer tarifaId, TarifaRequest request) {

        Tarifa tarifa = repository.findById(tarifaId)
            .orElseThrow(() -> new TarifaException("La tarifa con id " + tarifaId + " no existe."));

        // Actualizar campos
        tarifa.setRangoPesoMinKg(request.rangoPesoMinKg());
        tarifa.setRangoPesoMaxKg(request.rangoPesoMaxKg());
        tarifa.setRangoVolMinM3(request.rangoVolMinM3());
        tarifa.setRangoVolMaxM3(request.rangoVolMaxM3());
        tarifa.setCostoKmBase(request.costoKmBase());
        tarifa.setCargoGestionPorTramo(request.cargoGestionPorTramo());

        repository.save(tarifa);
        return tarifa.getTarifaId();
}

    public TarifaResponse getTarifaById(Integer id) {
        return repository
                .findById(id)
                .map(mapper::toResponse)
                .orElseThrow(() -> new TarifaException("La tarifa con id " + id + " no existe."));
    }

    public TarifaCalculoResponse calcularCostoEstimado(TarifaCalculoRequest request) {

        Tarifa tarifa = repository
                .findByRangoPesoMinKgLessThanEqualAndRangoPesoMaxKgGreaterThanEqualAndRangoVolMinM3LessThanEqualAndRangoVolMaxM3GreaterThanEqual(
                        request.peso(),
                        request.peso(),
                        request.volumen(),
                        request.volumen()
                )
                .orElseThrow(() -> new TarifaException("No existe tarifa válida para ese peso y volumen"));

        double costo = request.distanciaTotalKM() * tarifa.getCostoKmBase();

        // Si querés incluir el cargo por tramo:
        costo += tarifa.getCargoGestionPorTramo();

        return new TarifaCalculoResponse(costo);
    }
}