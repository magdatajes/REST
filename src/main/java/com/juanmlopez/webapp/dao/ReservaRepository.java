package com.juanmlopez.webapp.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.juanmlopez.webapp.domain.Mesa;
import com.juanmlopez.webapp.domain.Reserva;
import com.juanmlopez.webapp.domain.Restaurante;
import com.juanmlopez.webapp.domain.Turno;


public interface ReservaRepository extends CrudRepository <Reserva, Long> {
	
	List<Reserva> findByLocalizador(Long localizador);
	
	public List<Mesa> getMesasPorTurnoYRestaurante(Turno turno, Restaurante restaurante);
}
