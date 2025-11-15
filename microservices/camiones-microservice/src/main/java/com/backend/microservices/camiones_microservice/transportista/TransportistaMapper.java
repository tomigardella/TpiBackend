package com.backend.microservices.camiones_microservice.transportista;

import org.springframework.stereotype.Service;

@Service
public class TransportistaMapper {

    public TransportistaResponse toResponse(Transportista transportista) {
        return new TransportistaResponse(
            transportista.getTransportistaId(),
            transportista.getNombre(),
            transportista.getTipoDocumento(),
            transportista.getNroDocumento(),
            transportista.getTelefono(),
            transportista.getEmail(),
            transportista.getEmpresa()
        );
    }

    public Transportista toTransportista(TransportistaRequest request) {
        return Transportista.builder()
            .nombre(request.nombre())
            .tipoDocumento(request.tipoDocumento())
            .nroDocumento(request.nroDocumento())
            .telefono(request.telefono())
            .email(request.email())
            .empresa(request.empresa())
            .build();
    }
}
