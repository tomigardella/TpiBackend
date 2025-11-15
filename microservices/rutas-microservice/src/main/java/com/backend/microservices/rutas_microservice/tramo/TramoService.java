package com.backend.microservices.rutas_microservice.tramo;

import java.util.List;

import org.springframework.stereotype.Service;

import com.backend.microservices.rutas_microservice.client.CamionClient;
import com.backend.microservices.rutas_microservice.estado.Estado;
import com.backend.microservices.rutas_microservice.estado.EstadoRepository;
import com.backend.microservices.rutas_microservice.exceptions.EstadoException;
import com.backend.microservices.rutas_microservice.exceptions.RutaException;
import com.backend.microservices.rutas_microservice.exceptions.TipoTramoException;
import com.backend.microservices.rutas_microservice.exceptions.TramoException;
import com.backend.microservices.rutas_microservice.ruta.Ruta;
import com.backend.microservices.rutas_microservice.ruta.RutaRepository;
import com.backend.microservices.rutas_microservice.tipo_tramo.TipoTramo;
import com.backend.microservices.rutas_microservice.tipo_tramo.TipoTramoRepository;

import feign.FeignException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TramoService {

    private final RutaRepository rutaRepository;
    private final TramoRepository tramoRepository;
    private final TipoTramoRepository tipoTramoRepository;
    private final EstadoRepository estadoRepository;
    private final TramoMapper mapper;
    private final CamionClient camionClient;

    // Obtener todo tramo
    public List<TramoResponse> getAllTramos() {
        return tramoRepository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    // Crear tramo
    public TramoResponse createTramo(TramoRequest request) {
        Ruta ruta = rutaRepository.findById(request.ruta_id())
            .orElseThrow(() -> new RutaException("Ruta no encontrada."));

        TipoTramo tipoTramo = tipoTramoRepository.findById(request.tipoTramoId())
            .orElseThrow(() -> new TipoTramoException("Tipo Tramo no encontrado."));


        Tramo tramo = mapper.toTramo(request, ruta, tipoTramo);
        tramoRepository.save(tramo);
        return mapper.toResponse(tramo);
    }

    // Eliminar tramo
    public void deleteTramo(Integer id) {
        if (!tramoRepository.existsById(id)) {
            throw new TramoException("Tramo no encontrado con id: " + id);
        }
        tramoRepository.deleteById(id);
    }

    // Update tramo ( Asignar CAMION UNICAMENTE )
    public TramoResponse updateTramo(Integer tramoId, TramoUpdateRequest request) {

        Tramo tramo = tramoRepository.findById(tramoId)
                .orElseThrow(() -> new TramoException("Tramo no encontrado con id: " + tramoId));

        // Validar existencia del CAMION
        try {
            camionClient.getCamionById(request.camionId());
        } catch (FeignException.NotFound e) {
            throw new TramoException("Camion no encontrado con id: " + request.camionId());
        }

        tramo.setCamionId(request.camionId());

        tramo = tramoRepository.save(tramo);
        return mapper.toResponse(tramo);
    }

    // Update tramo ( Asignar CAMION UNICAMENTE )
    public TramoResponse updateEstadoTramo(Integer tramoId, TramoEstadoRequest request) {

        Tramo tramo = tramoRepository.findById(tramoId)
                .orElseThrow(() -> new TramoException("Tramo no encontrado con id: " + tramoId));

        // Validar existencia del Estado
        Estado nuevoEstado = estadoRepository.findById(request.estadoId())
                .orElseThrow(() -> new EstadoException("Estado no encontrado con id: " + tramoId));
        

        tramo.setEstado(nuevoEstado);

        tramo = tramoRepository.save(tramo);
        return mapper.toResponse(tramo);
    }

    // Iniciar tramo
    public TramoResponse iniciarTramo(Integer tramoId) {
        Tramo tramo = tramoRepository.findById(tramoId)
                .orElseThrow(() -> new TramoException("Tramo no encontrado con id: " + tramoId));

        tramo.setFechaHoraInicio(new java.sql.Timestamp(System.currentTimeMillis()));
        tramo.setEstado(estadoRepository.findAll().stream()
            .filter(e -> e.getNombre().equalsIgnoreCase("INICIADO"))
            .findFirst()
            .orElseThrow(() -> new EstadoException("Estado INICIADO no encontrado.")));

        tramoRepository.save(tramo);
        return mapper.toResponse(tramo);
    }

    // Finalizar tramo
    public TramoResponse finalizarTramo(Integer tramoId) {
        Tramo tramo = tramoRepository.findById(tramoId)
                .orElseThrow(() -> new TramoException("Tramo no encontrado con id: " + tramoId));

        tramo.setFechaHoraFin(new java.sql.Timestamp(System.currentTimeMillis()));
        tramo.setEstado(estadoRepository.findAll().stream()
            .filter(e -> e.getNombre().equalsIgnoreCase("FINALIZADO"))
            .findFirst()
            .orElseThrow(() -> new EstadoException("Estado FINALIZADO no encontrado.")));

        tramoRepository.save(tramo);
        return mapper.toResponse(tramo);
    }

}
