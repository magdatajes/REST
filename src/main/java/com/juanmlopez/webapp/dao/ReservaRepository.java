package com.juanmlopez.webapp.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.juanmlopez.webapp.domain.Reserva;

public interface ReservaRepository extends CrudRepository <Reserva, Long> {
	
	List<Reserva> findByLocalizador(Long localizador);
}
