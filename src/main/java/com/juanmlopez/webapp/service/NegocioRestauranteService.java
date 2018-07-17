package com.juanmlopez.webapp.service;

import java.util.List;

import com.juanmlopez.webapp.domain.Restaurante;
import com.juanmlopez.webapp.exception.DaoException;
import com.juanmlopez.webapp.exception.ServiceException;

public interface NegocioRestauranteService {

	Restaurante saveOrUpdate(Restaurante restaurante) throws ServiceException;

	void deleteRestaurante(Long id) throws ServiceException, DaoException;

	Restaurante findById(Long id) throws ServiceException, DaoException;

	List<Restaurante> findAll() throws ServiceException, DaoException;
	
	Restaurante findByNombre(String nombre) throws ServiceException, DaoException;
}
