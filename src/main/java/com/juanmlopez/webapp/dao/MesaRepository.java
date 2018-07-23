package com.juanmlopez.webapp.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.juanmlopez.webapp.domain.Mesa;

@Repository
public interface MesaRepository extends CrudRepository <Mesa, Long> {
	
}
