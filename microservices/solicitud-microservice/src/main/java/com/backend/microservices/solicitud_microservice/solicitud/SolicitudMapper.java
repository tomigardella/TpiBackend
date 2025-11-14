package com.backend.microservices.solicitud_microservice.solicitud;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Service;

import com.backend.microservices.solicitud_microservice.cliente.Cliente;
import com.backend.microservices.solicitud_microservice.cliente.ClienteMapper;
import com.backend.microservices.solicitud_microservice.estado.Estado;
import com.backend.microservices.solicitud_microservice.estado.EstadoMapper;
import com.backend.microservices.solicitud_microservice.tarifa.Tarifa;
import com.backend.microservices.solicitud_microservice.tarifa.TarifaMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SolicitudMapper {

    private final ClienteMapper clienteMapper;
    private final TarifaMapper tarifaMapper;
    private final EstadoMapper estadoMapper;

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public Solicitud toSolicitud(SolicitudRequest request, Cliente cliente, Tarifa tarifa, Estado estado) {
        return Solicitud.builder()
                .contenedorId(request.contenedorId())
                .origenId(request.origenId())
                .destinoId(request.destinoId())
                .direccionOrigen(request.direccionOrigen())
                .direccionDestino(request.direccionDestino())
                .costoEstimado(request.costoEstimado())
                .tiempoEstimado(request.tiempoEstimado())
                .tiempoReal(parseTimestamp(request.tiempoReal()))
                .fechaSolicitud(parseTimestamp(request.fechaSolicitud()))
                .costoFinal(request.costoFinal())
                .cliente(cliente)
                .tarifa(tarifa)
                .estadoActual(estado)
                .build();
    }

    private Timestamp parseTimestamp(String value) {
        if (value == null || value.isBlank()) return null;
        return Timestamp.valueOf(LocalDateTime.parse(value, FORMATTER));
    }

    public Timestamp toTimestamp(String value) {
        return parseTimestamp(value);
    }


    public SolicitudResponse toResponse(Solicitud solicitud) {
        return new SolicitudResponse(
                solicitud.getSolicitudId(),
                solicitud.getContenedorId(),
                solicitud.getOrigenId(),
                solicitud.getDestinoId(),
                solicitud.getDireccionOrigen(),
                solicitud.getDireccionDestino(),
                solicitud.getCostoEstimado(),
                solicitud.getTiempoEstimado(),
                solicitud.getTiempoReal(),
                solicitud.getFechaSolicitud(),
                solicitud.getCostoFinal(),
                solicitud.getCliente() != null ? clienteMapper.toResponse(solicitud.getCliente()) : null,
                solicitud.getTarifa() != null ? tarifaMapper.toResponse(solicitud.getTarifa()) : null,
                solicitud.getEstadoActual() != null ? estadoMapper.toResponse(solicitud.getEstadoActual()) : null
        );
    }
}
