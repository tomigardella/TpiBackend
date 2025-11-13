package com.backend.microservices.solicitud_microservice.estado;

import java.util.List;

import org.springframework.stereotype.Service;

import com.backend.microservices.solicitud_microservice.exceptions.EstadoException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EstadoService {

    private final EstadoRepository repository;
    private final EstadoMapper mapper;

    public List<EstadoResponse> getAllEstados() {
        return repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();

    }

    public Integer createEstado(EstadoRequest request) {
       Estado estado = mapper.toEstado(request);
       return repository.save(estado).getEstadoId();
    }

    public void deleteEstado(Integer id) {
        if (id == null) {
            throw new EstadoException("El id del estado no puede ser nulo.");
        }
        else if (!repository.existsById(id)) {
            throw new EstadoException("El Estado con id " + id + " no existe.");
        }
        repository.deleteById(id);
    }

    public Integer updateEstado(EstadoRequest request) {
        Estado estado = mapper.toEstado(request);
        if (request.estadoId() == null) {
            throw new EstadoException("El id del estado no puede ser nulo.");
        }
        else if (!repository.existsById(request.estadoId())) {
            throw new EstadoException("El Estado con id " + request.estadoId() + " no existe.");
        }
        repository.save(estado);
        return estado.getEstadoId();
    }

    public EstadoResponse getEstadoById(Integer id) {
        return repository
                .findById(id)
                .map(mapper::toResponse)
                .orElseThrow(() -> new EstadoException("El estado con id " + id + " no existe."));
    }
}
