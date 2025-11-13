package com.backend.microservices.solicitud_microservice.cliente;

import java.util.List;

import org.springframework.stereotype.Service;

import com.backend.microservices.solicitud_microservice.exceptions.ClienteException;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository repository;
    private final ClienteMapper mapper;

    public List<ClienteResponse> getAllClientes() {
        return repository
                .findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    public Integer createCliente(ClienteRequest request) {
        Cliente cliente = mapper.toCliente(request);
        return repository.save(cliente).getClienteId();
    }

    public ClienteResponse getClienteById(Integer id) {
       return  repository
                .findById(id)
                .map(mapper::toResponse)
                .orElseThrow(() -> new ClienteException("El Cliente con id " + id + " no existe."));

    }

    public Integer updateCliente(ClienteRequest request) {
        Cliente cliente = mapper.toCliente(request);
        if (request.clienteId() == null) {
            throw new ClienteException("El id de cliente no puede ser nulo.");
        }
        else if (!repository.existsById(request.clienteId())) {
            throw new ClienteException("El cliente con id " + request.clienteId() + " no existe.");
        }
        repository.save(cliente);
        return cliente.getClienteId();
    }

    public void deleteCliente(Integer id) {
        if (id == null) {
            throw new ClienteException("El id de cliente no puede ser nulo.");
        }
        else if (!repository.existsById(id)) {
            throw new ClienteException("El cliente con id " + id + " no existe.");
        }
        repository.deleteById(id);
    }

}
