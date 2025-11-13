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

    public Integer updateTarifa(TarifaRequest request) {
        Tarifa tarifa = mapper.toTarifa(request);
        if (request.tarifaId() == null) {
            throw new TarifaException("El id de tarifa no puede ser nulo.");
        }
        else if (!repository.existsById(request.tarifaId())) {
            throw new TarifaException("La tarifa con id " + request.tarifaId() + " no existe.");
        }
        repository.save(tarifa);
        return tarifa.getTarifaId();
    }

    public TarifaResponse getTarifaById(Integer id) {
        return repository
                .findById(id)
                .map(mapper::toResponse)
                .orElseThrow(() -> new TarifaException("La tarifa con id " + id + " no existe."));
    }
}