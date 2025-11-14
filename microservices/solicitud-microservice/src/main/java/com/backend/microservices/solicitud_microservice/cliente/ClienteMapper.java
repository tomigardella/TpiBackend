package com.backend.microservices.solicitud_microservice.cliente;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class ClienteMapper {

    public Cliente toCliente(ClienteRequest request) {
        return Cliente.builder()
                .nombre(request.nombre())
                .apellido(request.apellido())
                .tipoDocumento(request.tipoDocumento())
                .nroDocumento(request.nroDocumento())
                .telefono(request.telefono())
                .email(request.email())
                .direccion(request.direccion())
                .build();
    }

    public ClienteResponse toResponse(Cliente cliente) {

        List<Integer> solicitudesIds = cliente.getSolicitudes() != null
            ? cliente.getSolicitudes().stream()
                .map(s -> s.getSolicitudId())
                .collect(Collectors.toList())
            : List.of();

        return new ClienteResponse(
                cliente.getClienteId(),
                cliente.getNombre(),
                cliente.getApellido(),
                cliente.getTipoDocumento(),
                cliente.getNroDocumento(),
                cliente.getTelefono(),
                cliente.getEmail(),
                cliente.getDireccion(),
                solicitudesIds
        );
    }
}
