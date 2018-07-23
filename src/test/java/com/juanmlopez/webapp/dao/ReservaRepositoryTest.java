package com.juanmlopez.webapp.dao;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.juanmlopez.webapp.domain.Reserva;
import com.juanmlopez.webapp.exception.ServiceException;

@RunWith(SpringRunner.class)
@DataJpaTest
@WebAppConfiguration
public class ReservaRepositoryTest {

	@Autowired
	private ReservaRepository reservaRepository;

	@Autowired
	TestEntityManager entityManager;

	@Before
	public void populateDatabase() {
		entityManager.persistAndFlush(new Reserva((long) 123456));
	}

	@Test
	public void testGetReserva() {
		Optional<Reserva> reserva = reservaRepository.findByLocalizador((long) 222222).stream().findFirst();
		assertFalse(reserva.isPresent());
	}

	@Test
	public void testAddReserva() {

		Reserva reserva = new Reserva();
		long localizador = 987654;
		reserva.setLocalizador(localizador);
		reservaRepository.save(reserva);

		Optional<Reserva> found = reservaRepository.findByLocalizador(localizador).stream().findFirst();
		assertNotNull(found);
	}

	@Test
	public void reservaryFindByLocalizadorTest() throws ServiceException {
		Reserva reserva = new Reserva();
		List<Reserva> reservas = new ArrayList<Reserva>();
		reservas.add(reserva);
		long localizador = 123456;
		reserva.setId((long) 8);
		reserva.setLocalizador(localizador);
		reservaRepository.save(reserva);
		assertNotNull(reservaRepository.findByLocalizador(localizador).stream().findFirst());
	}
}
