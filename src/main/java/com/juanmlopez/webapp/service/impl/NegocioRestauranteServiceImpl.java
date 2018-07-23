package com.juanmlopez.webapp.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.juanmlopez.webapp.controller.dto.ReservaDTO;
import com.juanmlopez.webapp.dao.ReservaRepository;
import com.juanmlopez.webapp.dao.RestauranteRepository;
import com.juanmlopez.webapp.dao.TurnoRepository;
import com.juanmlopez.webapp.domain.Mesa;
import com.juanmlopez.webapp.domain.Reserva;
import com.juanmlopez.webapp.domain.Restaurante;
import com.juanmlopez.webapp.domain.Turno;
import com.juanmlopez.webapp.exception.DaoException;
import com.juanmlopez.webapp.exception.MesaException;
import com.juanmlopez.webapp.exception.ServiceException;
import com.juanmlopez.webapp.service.NegocioRestauranteService;

@Service("restauranteService")
public class NegocioRestauranteServiceImpl implements NegocioRestauranteService {

	@Autowired
	private RestauranteRepository restauranteRepository;
	@Autowired
	private ReservaRepository reservaRepository;
	@Autowired
	private TurnoRepository turnoRepository;

	public NegocioRestauranteServiceImpl(RestauranteRepository restauranteRepository,
			ReservaRepository reservaRepository, TurnoRepository turnoRepository) {
		super();
		this.restauranteRepository = restauranteRepository;
		this.reservaRepository = reservaRepository;
		this.turnoRepository = turnoRepository;
	}

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
		List<Reserva> reservas = (List<Reserva>) reservaRepository.findAll();
		Optional<Reserva> reservaEncontrada = reservas.stream().filter(r -> r.getId() == id).findFirst();
		if (!reservaEncontrada.isPresent()) {
			restauranteRepository.delete(id);
		} else {
			throw new DaoException();
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

	public Turno findByDescripcion(String descripcion) throws ServiceException, DaoException {
		if (descripcion == null) {
			throw new ServiceException();
		}
		Turno turno = turnoRepository.findByDescripcion(descripcion);
		if (turno == null) {
			throw new DaoException();
		}
		return turno;
	}

	public List<Restaurante> findAll() throws ServiceException, DaoException {
		return (List<Restaurante>) restauranteRepository.findAll();
	}

	public List<Reserva> findAllReservas() {
		return (List<Reserva>) reservaRepository.findAll();
	}

	@Override
	public Restaurante findByNombre(String nombre) throws ServiceException, DaoException {
		if (nombre == null || nombre.isEmpty()) {
			throw new ServiceException();
		}
		Restaurante restaurante = restauranteRepository.findByNombre(nombre);
		if (restaurante == null) {
			throw new DaoException();
		}
		return restaurante;
	}

	public Reserva findByLocalizador(Long localizador) throws ServiceException, DaoException {
		if (localizador == null) {
			throw new ServiceException();
		}

		List<Reserva> reservas = (List<Reserva>) reservaRepository.findAll();

		if (reservas.isEmpty()) {
			throw new DaoException();
		}
		return reservas.stream().filter(r -> r.getLocalizador().equals(localizador)).findFirst().get();
	}

	public Mesa asignarMesa(ReservaDTO reservaDTO) throws MesaException {
		Restaurante restaurante = restauranteRepository.findByNombre(reservaDTO.getRestaurante());
		Turno turno = turnoRepository.findByDescripcion(reservaDTO.getTurno());

		List<Mesa> mesasDelRestaurante = restaurante.getMesas();

		mesasDelRestaurante.sort((m1, m2) -> (m1.getCapacidad() - m2.getCapacidad()));
		List<Reserva> reservasExistentes = (List<Reserva>) reservaRepository.findAll();

		if (reservasExistentes.isEmpty()) {
			return mesasDelRestaurante.stream().filter(m -> m.getCapacidad() >= reservaDTO.getPersonas()).findFirst()
					.orElse(null);
		} else {
			List<Reserva> ReservasDelRestauranteYTurno = reservasExistentes.stream()
					.filter(m -> m.getTurno().equals(turno) && m.getRestaurante().equals(restaurante))
					.collect(Collectors.toList());
			List<Mesa> mesasReservadas = ReservasDelRestauranteYTurno.stream().map(Reserva::getMesa)
					.collect(Collectors.toList());

			List<Mesa> result = mesasDelRestaurante.stream().filter(m -> m.getCapacidad() >= reservaDTO.getPersonas())
					.filter(mk -> !mesasReservadas.contains(mk)).collect(Collectors.toList());

			return result.isEmpty() ? null : result.get(0);
		}
	}
}
