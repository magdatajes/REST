package com.juanmlopez.webapp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.juanmlopez.webapp.dao.ReservaRepository;
import com.juanmlopez.webapp.dao.RestauranteRepository;
import com.juanmlopez.webapp.domain.Reserva;
import com.juanmlopez.webapp.domain.Restaurante;
import com.juanmlopez.webapp.exception.DaoException;
import com.juanmlopez.webapp.exception.ServiceException;
import com.juanmlopez.webapp.service.NegocioRestauranteService;

@Service("restauranteService")
public class NegocioRestauranteServiceImpl implements NegocioRestauranteService {

	@Autowired
	private RestauranteRepository restauranteRepository;
	@Autowired
	private ReservaRepository reservaRepository;

	@Transactional
	@Override
	public Restaurante saveOrUpdate(Restaurante restaurante) throws ServiceException {
		if (restaurante == null) {
			throw new ServiceException();
		}
		return restauranteRepository.save(restaurante);
	}

	@Transactional
	public Reserva saveOrUpdateReserva(Reserva reserva) throws ServiceException {
		if (reserva == null) {
			throw new ServiceException();
		}
		return reservaRepository.save(reserva);
	}

	@Transactional
	public void deleteRestaurante(Long id) throws ServiceException, DaoException {
		if (id == null) {
			throw new ServiceException();
		}
		List <Reserva> reservas= findAllReservas();
		Optional<Reserva> reservaEncontrada= reservas.stream().filter(r -> r.getId()==id).findFirst();
		if(!reservaEncontrada.isPresent()) {
			restauranteRepository.delete(id);
		}
		
	}

	@Transactional
	public void deleteReservaByLocalizador(Long localizador) throws ServiceException, DaoException {
		if (localizador == null) {
			throw new ServiceException();
		}
		Reserva reserva = findByLocalizador(localizador);
		reservaRepository.delete(reserva.getId());
	}

	@Override
	public Restaurante findById(Long id) throws ServiceException, DaoException {
		if (id == null) {
			throw new ServiceException();
		}
		Restaurante restaurante = restauranteRepository.findOne(id);
		if (restaurante == null) {
			throw new DaoException();
		}
		return restaurante;
	}

	public List<Restaurante> findAll() throws ServiceException, DaoException {
		return (List<Restaurante>) restauranteRepository.findAll();
	}

	public List<Reserva> findAllReservas() throws ServiceException, DaoException {
		return (List<Reserva>) reservaRepository.findAll();
	}

	@Override
	public Restaurante findByNombre(String nombre) throws ServiceException, DaoException {
		if (nombre == null || nombre.isEmpty()) {
			throw new ServiceException();
		}
		List<Restaurante> restaurante = restauranteRepository.findByNombre(nombre);
		if (restaurante.isEmpty()) {
			throw new DaoException();
		}
		return restaurante.stream().findFirst().get();
	}

	public Reserva findByLocalizador(Long localizador) throws ServiceException, DaoException {
		if (localizador == null) {
			throw new ServiceException();
		}
		List<Reserva> reservas = reservaRepository.findByLocalizador(localizador);
		if (reservas.isEmpty()) {
			throw new DaoException();
		}
		return reservas.stream().findFirst().get();
	}

}
