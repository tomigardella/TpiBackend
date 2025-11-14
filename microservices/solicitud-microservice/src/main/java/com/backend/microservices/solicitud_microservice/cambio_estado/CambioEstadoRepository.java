package com.backend.microservices.solicitud_microservice.cambio_estado;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.microservices.solicitud_microservice.solicitud.Solicitud;

@Repository
public interface CambioEstadoRepository extends JpaRepository<CambioEstado, Integer>{

    CambioEstado findTopBySolicitudOrderByFechaDesdeDesc(Solicitud solicitud);
}
