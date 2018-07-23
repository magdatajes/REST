package com.juanmlopez.webapp.dao;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.juanmlopez.webapp.domain.Turno;
@Repository
public interface TurnoRepository extends CrudRepository <Turno, Long> {
	
	Turno findByDescripcion(String descripcion);
}
