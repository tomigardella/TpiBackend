package com.backend.microservices.rutas_microservice.tramo;

import java.sql.Timestamp;

import com.backend.microservices.rutas_microservice.estado.EstadoResponse;
import com.backend.microservices.rutas_microservice.ruta.RutaResponse;
import com.backend.microservices.rutas_microservice.tipo_tramo.TipoTramoResponse;

public record TramoResponse(
    Integer tramoId,
    RutaResponse ruta,
    TipoTramoResponse tipoTramo,
    EstadoResponse estadoActual,
    Integer depositoOrigenId,
    Integer depositoDestinoId,
    Double costoAproximado,
    Double costoReal,
    Timestamp fechaHoraInicio,
    Timestamp fechaHoraFin,
    Integer camionId
) {

}
