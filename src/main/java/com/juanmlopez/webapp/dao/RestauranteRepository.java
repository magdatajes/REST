package com.juanmlopez.webapp.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


import com.juanmlopez.webapp.domain.Restaurante;


public interface RestauranteRepository extends CrudRepository <Restaurante, Long>  {
	 
	List<Restaurante> findByNombre(String nombre);
}
