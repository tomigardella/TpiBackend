package com.backend.microservices.depositos_microservice.estadiaDeposito;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.backend.microservices.depositos_microservice.exceptions.EstadiaDepositoException;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class EstadiaDepositoService {

    private final EstadiaDepositoRepository repository;
    private final EstadiaDepositoMapper mapper;

    public Integer createEstadiaDeposito(EstadiaDepositoRequest request) {
        EstadiaDeposito EstadiaDeposito = mapper.toEstadiaDeposito(request);
        repository.save(EstadiaDeposito);
        return EstadiaDeposito.getEstadiaDepositoID();
    }


    public List<EstadiaDepositoResponse> getAllEstadiaDepositos() {
        return repository
                .findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    public Integer updateEstadiaDeposito(Integer EstadiaDepositoId, EstadiaDepositoRequest request) {
        EstadiaDeposito estadiaDeposito = repository.findById(EstadiaDepositoId)
            .orElseThrow(() -> new EstadiaDepositoException("El EstadiaDeposito con id " + EstadiaDepositoId + " no existe."));
        
            estadiaDeposito.setFechaEntrada(request.fechaEntrada());
            estadiaDeposito.setFechaSalida(request.fechaSalida());
            estadiaDeposito.setDiasEstadia(request.diasEstadia());
            estadiaDeposito.setContenedorId(request.contenedorId());
        
        repository.save(estadiaDeposito);
        return estadiaDeposito.getEstadiaDepositoID();
    }

    public void registrarSalida(Integer id) {
        EstadiaDeposito estadiaDeposito = repository.findById(id)
            .orElseThrow(() -> new EstadiaDepositoException("La estadía con id " + id + " no existe."));
        
        if (estadiaDeposito.getFechaSalida() != null) {
            throw new EstadiaDepositoException("La estadía con id " + id + " ya tiene registrada una salida.");
        }
        
        estadiaDeposito.setFechaSalida(Timestamp.valueOf(LocalDateTime.now()));
        repository.save(estadiaDeposito);
    }

    public void deleteEstadiaDeposito(Integer id) {
        if (!repository.existsById(id)) {
            throw new EstadiaDepositoException("La estadía con id " + id + " no existe.");
        }
        repository.deleteById(id);
    }

}
