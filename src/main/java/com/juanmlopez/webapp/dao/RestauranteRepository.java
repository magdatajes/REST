package com.juanmlopez.webapp.dao;

import org.springframework.data.repository.CrudRepository;


import com.juanmlopez.webapp.domain.Restaurante;


public interface RestauranteRepository extends CrudRepository <Restaurante, Long>  {
	 
	Restaurante findByNombre(String nombre);
}
