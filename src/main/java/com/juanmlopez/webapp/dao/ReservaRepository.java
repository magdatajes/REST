package com.juanmlopez.webapp.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.juanmlopez.webapp.domain.Reserva;

@Repository
public interface ReservaRepository extends CrudRepository <Reserva, Long> {
	
	List<Reserva> findByLocalizador(Long localizador);
}
