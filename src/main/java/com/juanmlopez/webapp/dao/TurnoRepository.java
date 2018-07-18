package com.juanmlopez.webapp.dao;


import org.springframework.data.repository.CrudRepository;

import com.juanmlopez.webapp.domain.Turno;

public interface TurnoRepository extends CrudRepository <Turno, Long> {
	
	Turno findByDescripcion(String descripcion);
}
