package com.backend.microservices.depositos_microservice.deposito;

import java.util.List;

import org.springframework.stereotype.Service;

import com.backend.microservices.depositos_microservice.exceptions.DepositoException;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class DepositoService {

    private final DepositoRepository repository;
    private final DepositoMapper mapper;

    public Integer createDeposito(DepositoRequest request) {
        Deposito deposito = mapper.toDeposito(request);
        repository.save(deposito);
        return deposito.getDepositoId();
    }


    public List<DepositoResponse> getAllDepositos() {
        return repository
                .findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    public Integer updateDeposito(Integer depositoId, DepositoRequest request) {
        Deposito deposito = repository.findById(depositoId)
            .orElseThrow(() -> new DepositoException("El deposito con id " + depositoId + " no existe."));
        
            deposito.setNombre(request.nombre());
            deposito.setDireccion(request.direccion());
            deposito.setCapacidadPesoKg(request.capacidadPesoKg());
            deposito.setCapacidadVolumenM3(request.capacidadVolumenM3());
            deposito.setCostoDia(request.costoDia());
        
        repository.save(deposito);
        return deposito.getDepositoId();
    }

    public List<?> getContenedoresByDeposito(Integer depositoId) {
        // Implementar lógica para obtener contenedores
        // Puede requerir llamada a otro microservicio o relación en BD
        throw new UnsupportedOperationException("Implementar getContenedoresByDeposito");
    }

    public void deleteDeposito(Integer depositoId) {
        if (!repository.existsById(depositoId)) {
            throw new EntityNotFoundException("Deposito no encontrado con id: " + depositoId);
        }
        repository.deleteById(depositoId);
    }

}
