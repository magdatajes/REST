package com.juanmlopez.webapp.domain;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class ReservaTest {
	@Test
    public void testNewReserva() {
        Reserva reserva = new Reserva();
        reserva.setLocalizador((long) 987654);
        assertNotNull(reserva);
        assertNotNull(reserva.getLocalizador());
    }
}
