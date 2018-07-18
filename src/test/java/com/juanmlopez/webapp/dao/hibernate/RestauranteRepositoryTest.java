package com.juanmlopez.webapp.dao.hibernate;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import com.juanmlopez.webapp.WebApp;
import com.juanmlopez.webapp.dao.RestauranteRepository;
import com.juanmlopez.webapp.domain.Restaurante;
import com.juanmlopez.webapp.exception.DaoException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;



@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = WebApp.class)
public class RestauranteRepositoryTest extends AbstractJUnit4SpringContextTests {
	
	@Autowired
    private RestauranteRepository restauranteRepository;
	
    @After
    public void tearDown() throws DaoException {
       restauranteRepository.deleteAll();
    }

    @Test
    public void testGetRestauranteNotFound() throws DaoException {
    	Restaurante restaurante= restauranteRepository.findByNombre("not found");
        assertNull(restaurante);
    }

    @Test
    public void testAddRestaurante() throws DaoException {
        String name = "name";
        Restaurante restaurante = new Restaurante(name);
        restaurante.setId((long) 20);
        restauranteRepository.save(restaurante);
        
		Restaurante found = restauranteRepository.findByNombre(name);
        assertNull(restauranteRepository.findByNombre(name));
        assertEquals(name, found.getNombre());
    }
}