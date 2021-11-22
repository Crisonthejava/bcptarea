package com.bcp.api.repository;

import com.bcp.api.model.entity.MonedaEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MonedasRepository extends JpaRepository<MonedaEntity, Integer> {

	MonedaEntity findByMonedaorigenAndMonedadestino(String monedaOrigen, String monedaDestino);

}
