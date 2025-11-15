package com.backend.microservices.rutas_microservice.tipo_tramo;

import java.util.List;

import org.springframework.stereotype.Service;

import com.backend.microservices.rutas_microservice.exceptions.TipoTramoException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TipoTramoService {

    private final TipoTramoRepository repository;
    private final TipoTramoMapper mapper;


    public List<TipoTramoResponse> getAllTiposTramo() {
        return repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    public TipoTramoResponse createTipoTramo(TipoTramoRequest request) {
       TipoTramo tipoTramo = mapper.toTipoTramo(request);
       repository.save(tipoTramo);

       return mapper.toResponse(tipoTramo);
    }

    public void deleteTipoTramo(Integer id) {
        if (id == null) {
            throw new TipoTramoException("El id del tipo tramo no puede ser nulo.");
        }
        else if (!repository.existsById(id)) {
            throw new TipoTramoException("El Tipo Tramo con id " + id + " no existe.");
        }
        repository.deleteById(id);
    }

    public TipoTramoResponse updateTipoTramo(Integer tipoTramoId, TipoTramoRequest request) {
        TipoTramo tipoTramo = repository.findById(tipoTramoId)
            .orElseThrow(() -> new TipoTramoException("El Tipo Tramo con id " + tipoTramoId + " no existe."));

            tipoTramo.setDescripcion(request.descripcion());
        
        repository.save(tipoTramo);
        return mapper.toResponse(tipoTramo);
    }
}
