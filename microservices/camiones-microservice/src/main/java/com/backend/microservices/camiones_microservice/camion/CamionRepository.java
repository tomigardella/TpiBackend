package com.backend.microservices.camiones_microservice.camion;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CamionRepository extends JpaRepository<Camion, Integer> {
    List<Camion> findByDisponibleTrue();
}
