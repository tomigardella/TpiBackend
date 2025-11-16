package com.backend.microservices.contenedor_microservice.contenedor;

import java.util.List;

import org.springframework.stereotype.Service;

import com.backend.microservices.contenedor_microservice.client.ClienteClient;
import com.backend.microservices.contenedor_microservice.client.GeolocalizacionClient;
import com.backend.microservices.contenedor_microservice.estado.Estado;
import com.backend.microservices.contenedor_microservice.estado.EstadoRepository;
import com.backend.microservices.contenedor_microservice.exceptions.ContenedorException;
import com.backend.microservices.contenedor_microservice.exceptions.EstadoException;

import feign.FeignException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ContenedorService {

    private final ContenedorRepository contenedorRepository;
    private final EstadoRepository estadoRepository;
    private final ContenedorMapper mapper;
    private final ClienteClient clienteClient;
    private final GeolocalizacionClient geolocalizacionClient;


    public List<ContenedorResponse> getAllContenedores() {
        return contenedorRepository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    public List<ContenedorResponse> getAllContenedoresEstado(String estado) {
        return contenedorRepository.findByEstadoNombre(estado)
                .stream()
                .map(mapper::toResponse)
                .toList();
    }
    
    public void deleteContenedor(Integer id) {
        if (!contenedorRepository.existsById(id)) {
            throw new ContenedorException("Contenedor no encontrado con id: " + id);
        }
        contenedorRepository.deleteById(id);
    }

    public ContenedorResponse createContenedor(ContenedorRequest request) {

        try {
            clienteClient.getClienteById(request.clienteId());
        } catch (FeignException.NotFound e) {
            throw new ContenedorException("Cliente no encontrado con id: " + request.clienteId());
        }

        try {
            geolocalizacionClient.getGeolocalizacionById(request.geolocalizacionId());
        } catch (FeignException.NotFound e) {
            throw new ContenedorException("Geolocalizacion no encontrada con id: " + request.geolocalizacionId());
        }

        Estado estado = estadoRepository.findById(request.estadoId())
                .orElseThrow(() -> new ContenedorException("Estado no encontrado"));

        Contenedor contenedor = mapper.toContenedor(request, estado);
        contenedorRepository.save(contenedor);
        return mapper.toResponse(contenedor);
    }

    public void updateContenedor(Integer contenedorId, ContenedorUpdateRequest request) {
        Contenedor contenedor = contenedorRepository.findById(contenedorId)
                .orElseThrow(() -> new ContenedorException("Contenedor no encontrado con id: " + contenedorId));

        Estado estado = estadoRepository.findById(request.estadoId())
                .orElseThrow(() -> new ContenedorException("Estado no encontrado"));

        contenedor.setPesoKg(request.peso());
        contenedor.setVolumenM3(request.volumen());
        contenedor.setEstado(request.estadoId() != null ? estado : contenedor.getEstado());
        contenedorRepository.save(contenedor);
    }

    public void updateEstadoContenedor(Integer contenedorId, EstadoUpdateRequest request) {
        Contenedor contenedor = contenedorRepository.findById(contenedorId)
                .orElseThrow(() -> new ContenedorException("Contenedor no encontrado con id: " + contenedorId));

        Estado estado = estadoRepository.findById(request.estadoId())
                .orElseThrow(() -> new ContenedorException("Estado no encontrado"));

        contenedor.setEstado(estado);
        contenedorRepository.save(contenedor);
    }

    public ContenedorResponse getContenedorById(Integer contenedorId) {
        Contenedor contenedor = contenedorRepository.findById(contenedorId)
                .orElseThrow(() -> new ContenedorException("Contenedor no encontrado con id: " + contenedorId));

        return mapper.toResponse(contenedor);
    }
}