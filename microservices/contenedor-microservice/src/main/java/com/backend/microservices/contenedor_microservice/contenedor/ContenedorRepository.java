package com.backend.microservices.contenedor_microservice.contenedor;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.backend.microservices.contenedor_microservice.estado.Estado;

import feign.Param;


@Repository
public interface ContenedorRepository extends JpaRepository<Contenedor, Integer> {

    @Query("SELECT c FROM Contenedor c WHERE LOWER(c.estado.nombre) = LOWER(:nombreEstado)")
    List<Contenedor> findByEstadoNombre(@Param("nombreEstado") String nombreEstado);
}
