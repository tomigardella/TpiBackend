package com.backend.microservices.geolocalizacion_microservice.geolocalizacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.microservices.geolocalizacion_microservice.geolocalizacion.model.Geolocalizacion;

@Repository
public interface GeolocalizacionRepository extends JpaRepository<Geolocalizacion, Integer> {

}
