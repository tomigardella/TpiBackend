package com.backend.microservices.geolocalizacion_microservice.geolocalizacion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.backend.microservices.geolocalizacion_microservice.geolocalizacion.model.Geolocalizacion;
import com.backend.microservices.geolocalizacion_microservice.geolocalizacion.repository.GeolocalizacionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GeolocalizacionService {

    private final GeolocalizacionRepository repository;

    public Geolocalizacion createGeolocalizacion(Geolocalizacion geolocalizacion) {
        return repository.save(geolocalizacion);
    }

    public List<Geolocalizacion> getAll() {
        return repository.findAll();
    }

    public Optional<Geolocalizacion> getById(Integer id) {
        return repository.findById(id);
    }

    public Geolocalizacion updateGeolocalizacion(Integer id, Geolocalizacion geo) {
        return repository.findById(id)
                .map(g -> {
                    g.setLatitud(geo.getLatitud());
                    g.setLongitud(geo.getLongitud());
                    g.setDescripcion(geo.getDescripcion());
                    return repository.save(g);
                }).orElseThrow(() -> new RuntimeException("Geolocalizacion no encontrada"));
    }

    public void deleteGeolocalizacion(Integer id) {
        repository.deleteById(id);
    }

}
