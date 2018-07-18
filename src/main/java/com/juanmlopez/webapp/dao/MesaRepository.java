package com.juanmlopez.webapp.dao;

import org.springframework.data.repository.CrudRepository;

import com.juanmlopez.webapp.domain.Mesa;

public interface MesaRepository extends CrudRepository <Mesa, Long> {
	
}
