package com.backend.microservices.depositos_microservice.deposito;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepositoRepository extends JpaRepository<Deposito, Integer> {

}
