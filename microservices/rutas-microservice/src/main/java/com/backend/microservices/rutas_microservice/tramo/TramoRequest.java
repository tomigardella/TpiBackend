package com.backend.microservices.rutas_microservice.tramo;

import jakarta.validation.constraints.NotNull;

public record TramoRequest(
    
    @NotNull(message = "El ID de RUTA no puede ser nulo.")
    Integer ruta_id,

    @NotNull(message = "El ID del DEPOSITO ORIGEN no puede ser nulo.")
    Integer depositoOrigenId,

    @NotNull(message = "El ID del DEPOSITO DESTINO no puede ser nulo.")
    Integer depositoDestinoId,

    @NotNull(message = "El ID del TIPO DE TRAMO no puede ser nulo.")
    Integer tipoTramoId,

    @NotNull(message = "El COSTO APROXIMADO no puede ser nulo.")
    Double costoAproximado
) {

}
