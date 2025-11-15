package com.backend.microservices.rutas_microservice.tramo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TramoRepository extends JpaRepository<Tramo, Integer> {

}
