package com.juanmlopez.webapp.service;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.juanmlopez.webapp.dao.ReservaRepository;
import com.juanmlopez.webapp.dao.RestauranteRepository;
import com.juanmlopez.webapp.dao.TurnoRepository;
import com.juanmlopez.webapp.domain.Reserva;
import com.juanmlopez.webapp.domain.Restaurante;
import com.juanmlopez.webapp.exception.DaoException;
import com.juanmlopez.webapp.exception.ServiceException;
import com.juanmlopez.webapp.service.impl.NegocioRestauranteServiceImpl;

@RunWith(SpringRunner.class)
@DataJpaTest
@WebAppConfiguration
public class NegocioServiceTest {

	@Autowired
	RestauranteRepository restauranteRepository;
	@Autowired
	private ReservaRepository reservaRepository;
	@Autowired
	private TurnoRepository turnoRepository;

	NegocioRestauranteServiceImpl negocioService = new NegocioRestauranteServiceImpl(restauranteRepository,
			reservaRepository, turnoRepository);

	@Autowired
	TestEntityManager entityManager;

	@Before(value = "")
	public void populateDatabase() throws ServiceException {
		Restaurante restaurante = new Restaurante();
		List<Reserva> reservas = new ArrayList<>();
		Reserva reserva = new Reserva();
		restaurante.setNombre("restaurante1");
		reserva.setRestaurante(restaurante);
		reserva.setId((long) 1);
		reservas.add(reserva);

		reservaRepository.save(reserva);
		restaurante.setReservas(reservas);
		restauranteRepository.save(restaurante);

		entityManager.persistAndFlush(reserva);

		entityManager.persistAndFlush(restaurante);
	}

	 @Test
	 public void BorrarRestauranteConReservasFalla() throws DaoException,
	 ServiceException{
	 Restaurante resto= new Restaurante();
	 Reserva reserva = new Reserva();
	 List<Reserva> reservas = new ArrayList<>();
	
	 reserva.setRestaurante(resto);
	 reservas.add(reserva);
	
	 reservaRepository.save(reserva);
	
	 resto.setReservas(reservas);
	 assertNotNull(resto.getReservas());
	 restauranteRepository.save(resto);
	 long id = resto.getId();	
	 negocioService.deleteRestaurante(id);
	 }

	@Test(expected = ServiceException.class)
	public void BorrarPorLocalizadorFalla() throws DaoException, ServiceException {
		negocioService.deleteReservaByLocalizador(null);
	}

	@Test 
	public void BorrarPorLocalizador() throws DaoException, ServiceException {
		Reserva reserva = new Reserva();
		long localizador= 123465;
		reserva.setLocalizador(localizador);
		reservaRepository.save(reserva);
		entityManager.persistAndFlush(reserva);
		negocioService.deleteReservaByLocalizador(localizador);
	}
	
	@Test (expected= DaoException.class)
	public void BuscarTurnoPorDescripcionTest() throws ServiceException, DaoException {
		String descripcion= "descripcion erronea";
		negocioService.findByDescripcion(descripcion);
	}

}
