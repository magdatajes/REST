package com.juanmlopez.webapp.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.juanmlopez.webapp.domain.Restaurante;

@Repository
public interface RestauranteRepository extends CrudRepository <Restaurante, Long>  {
	 
	Restaurante findByNombre(String nombre);
}
