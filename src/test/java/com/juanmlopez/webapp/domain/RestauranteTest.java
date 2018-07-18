package com.juanmlopez.webapp.domain;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;

public class RestauranteTest {

    @Test
    public void testNewRestaurante() {
        Restaurante restaurante = new Restaurante("board");

        assertNotNull(restaurante);
        assertNotNull(restaurante.getNombre());
    }

    @Test(expected = NullPointerException.class)
    public void testNewRestauranteFailsOnNullParam() {
        new Restaurante(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNewRestauranteFailsOnEmptyParam() {
        new Restaurante("");
    }

}