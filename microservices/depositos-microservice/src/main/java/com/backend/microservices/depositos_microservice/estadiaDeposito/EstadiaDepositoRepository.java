package com.backend.microservices.depositos_microservice.estadiaDeposito;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadiaDepositoRepository extends JpaRepository<EstadiaDeposito, Integer> {

}
