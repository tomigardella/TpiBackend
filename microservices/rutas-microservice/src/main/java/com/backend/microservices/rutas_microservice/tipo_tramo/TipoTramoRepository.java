package com.backend.microservices.rutas_microservice.tipo_tramo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoTramoRepository extends JpaRepository<TipoTramo, Integer> {

}
