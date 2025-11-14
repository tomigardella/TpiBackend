package com.backend.microservices.solicitud_microservice.solicitud;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.stereotype.Service;

import com.backend.microservices.solicitud_microservice.cambio_estado.CambioEstado;
import com.backend.microservices.solicitud_microservice.cambio_estado.CambioEstadoRepository;
import com.backend.microservices.solicitud_microservice.cambio_estado.CambioEstadoRequest;
import com.backend.microservices.solicitud_microservice.cliente.Cliente;
import com.backend.microservices.solicitud_microservice.cliente.ClienteRepository;
import com.backend.microservices.solicitud_microservice.estado.Estado;
import com.backend.microservices.solicitud_microservice.estado.EstadoRepository;
import com.backend.microservices.solicitud_microservice.exceptions.SolicitudException;
import com.backend.microservices.solicitud_microservice.tarifa.Tarifa;
import com.backend.microservices.solicitud_microservice.tarifa.TarifaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SolicitudService {

    private final SolicitudRepository solicitudRepository;
    private final ClienteRepository clienteRepository;
    private final TarifaRepository tarifaRepository;
    private final EstadoRepository estadoRepository;
    private final CambioEstadoRepository cambioEstadoRepository;
    private final SolicitudMapper mapper;

    // Obtener todas las solicitudes
    public List<SolicitudResponse> getAllSolicitudes() {
        return solicitudRepository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    // Obtener una solicitud por ID
    public SolicitudResponse getSolicitudById(Integer id) {
        return solicitudRepository.findById(id)
                .map(mapper::toResponse)
                .orElseThrow(() -> new SolicitudException("Solicitud no encontrada con id: " + id));
    }

    // Crear una nueva solicitud
    public Integer createSolicitud(SolicitudRequest request) {
        Cliente cliente = clienteRepository.findById(request.clienteId())
                .orElseThrow(() -> new SolicitudException("Cliente no encontrado"));
        Tarifa tarifa = tarifaRepository.findById(request.tarifaId())
                .orElseThrow(() -> new SolicitudException("Tarifa no encontrada"));
        Estado estado = estadoRepository.findById(request.estadoId())
                .orElseThrow(() -> new SolicitudException("Estado no encontrado"));

        Solicitud solicitud = mapper.toSolicitud(request, cliente, tarifa, estado);
        solicitudRepository.save(solicitud);
        return solicitud.getSolicitudId();
    }

    // Actualizar una solicitud existente
    public void updateSolicitud(SolicitudRequest request) {
        Solicitud solicitud = solicitudRepository.findById(request.solicitudId())
                .orElseThrow(() -> new SolicitudException("Solicitud no encontrada"));

        Cliente cliente = clienteRepository.findById(request.clienteId())
                .orElseThrow(() -> new SolicitudException("Cliente no encontrado"));
        Tarifa tarifa = tarifaRepository.findById(request.tarifaId())
                .orElseThrow(() -> new SolicitudException("Tarifa no encontrada"));
        Estado estado = estadoRepository.findById(request.estadoId())
                .orElseThrow(() -> new SolicitudException("Estado no encontrado"));

        // 🔸 Usa el mapper para parsear timestamps correctamente
        Timestamp tiempoReal = mapper.toTimestamp(request.tiempoReal());
        Timestamp fechaSolicitud = mapper.toTimestamp(request.fechaSolicitud());

        solicitud.setContenedorId(request.contenedorId());
        solicitud.setOrigenId(request.origenId());
        solicitud.setDestinoId(request.destinoId());
        solicitud.setDireccionOrigen(request.direccionOrigen());
        solicitud.setDireccionDestino(request.direccionDestino());
        solicitud.setCostoEstimado(request.costoEstimado());
        solicitud.setTiempoEstimado(request.tiempoEstimado());
        solicitud.setTiempoReal(tiempoReal);
        solicitud.setFechaSolicitud(fechaSolicitud);
        solicitud.setCostoFinal(request.costoFinal());
        solicitud.setCliente(cliente);
        solicitud.setTarifa(tarifa);
        solicitud.setEstadoActual(estado);

        solicitudRepository.save(solicitud);
    }

    // Eliminar una solicitud
    public void deleteSolicitud(Integer id) {
        if (!solicitudRepository.existsById(id)) {
            throw new SolicitudException("Solicitud no encontrada con id: " + id);
        }
        solicitudRepository.deleteById(id);
    }

    public void cambiarEstadoSolicitud(Integer solicitudId, CambioEstadoRequest request) {
        Solicitud solicitud = solicitudRepository.findById(solicitudId)
                .orElseThrow(() -> new SolicitudException("Solicitud no encontrada con id: " + solicitudId));

        Estado nuevoEstado = estadoRepository.findById(request.estadoId())
                .orElseThrow(() -> new SolicitudException("Estado no encontrado con id: " + request.estadoId()));

        // Registrar cambio de estado anterior en la tabla CambioEstado
        CambioEstado ultimoCambio = cambioEstadoRepository.findTopBySolicitudOrderByFechaDesdeDesc(solicitud);
        if (ultimoCambio != null) {
                ultimoCambio.setFechaHasta(new java.sql.Timestamp(System.currentTimeMillis()));
                cambioEstadoRepository.save(ultimoCambio);
        }

        CambioEstado nuevoCambio = new CambioEstado();
        nuevoCambio.setSolicitud(solicitud);
        nuevoCambio.setEstado(nuevoEstado);
        nuevoCambio.setFechaDesde(new java.sql.Timestamp(System.currentTimeMillis()));
        nuevoCambio.setFechaHasta(null);

        cambioEstadoRepository.save(nuevoCambio);

        // Actualizar estado actual en la solicitud
        solicitud.setEstadoActual(nuevoEstado);
        solicitudRepository.save(solicitud);
   }
}

