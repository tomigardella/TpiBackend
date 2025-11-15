package com.backend.microservices.solicitud_microservice.tarifa;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarifaRepository extends JpaRepository<Tarifa, Integer>  {
    Optional<Tarifa> findByRangoPesoMinKgLessThanEqualAndRangoPesoMaxKgGreaterThanEqualAndRangoVolMinM3LessThanEqualAndRangoVolMaxM3GreaterThanEqual(
        Double pesoMinCheck,
        Double pesoMaxCheck,
        Double volMinCheck,
        Double volMaxCheck
    );
}
