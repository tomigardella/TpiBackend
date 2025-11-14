package com.backend.microservices.camiones_microservice.transportista;

import java.util.List;

import org.springframework.stereotype.Service;

import com.backend.microservices.camiones_microservice.exceptions.TransportistaException;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class TransportistaService {

    private final TransportistaRepository repository;
    private final TransportistaMapper mapper;

    public List<TransportistaResponse> getAllTransportistas() {
        return repository
                .findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    public Integer createTransportista(TransportistaRequest request) {
        Transportista transportista = mapper.toTransportista(request);
        return repository.save(transportista).getTransportistaId();
    }

    public void deleteTransportista(Integer id) {
        if (id == null) {
            throw new TransportistaException("El ID del transportista no puede ser nulo.");
        }
        else if (!repository.existsById(id)) {
            throw new TransportistaException("El transportista con id " + id + " no existe.");
        }
        repository.deleteById(id);
    }

    public Integer updateTransportista(Integer transportistaId, TransportistaRequest request) {
        Transportista transportista = repository.findById(transportistaId)
            .orElseThrow(() -> new TransportistaException("El transportista con id " + transportistaId + " no existe."));
        
            transportista.setNombre(request.nombre());
            transportista.setEmail(request.email());
            transportista.setEmpresa(request.empresa());
            transportista.setNroDocumento(request.nroDocumento());
            transportista.setTelefono(request.telefono());
            transportista.setTipoDocumento(request.tipoDocumento());
        
        repository.save(transportista);
        return transportista.getTransportistaId();
    }

}
