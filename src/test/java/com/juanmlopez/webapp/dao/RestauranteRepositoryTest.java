package com.juanmlopez.webapp.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.juanmlopez.webapp.domain.Restaurante;


@RunWith(SpringRunner.class)
@DataJpaTest
@WebAppConfiguration
public class RestauranteRepositoryTest{
	
	@Autowired
    private RestauranteRepository restauranteRepository;
	
	@Autowired
	TestEntityManager entityManager;
	
	 @Before
	 public void populateDatabase() {
		 entityManager.persistAndFlush(new Restaurante("rest"));
	    }

    @Test
    public void testGetRestauranteNotFound() {
    	Restaurante restaurante= restauranteRepository.findByNombre("not found");
        assertNull(restaurante);
    }
  
	@Test
    public void testAddRestaurante() {
        String name = "name";
        Restaurante restaurante = new Restaurante(name);
        restaurante.setId((long) 20);
        restauranteRepository.save(restaurante);
        
		Restaurante found = restauranteRepository.findByNombre(name);
        assertNotNull(found);
        assertEquals(name, found.getNombre());
    }

    
    @After
    public void tearDown() {
       restauranteRepository.deleteAll();
    }
}