package com.juanmlopez.webapp.resource;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import com.juanmlopez.webapp.controller.dto.RestauranteDTO;
import com.juanmlopez.webapp.controller.mapper.RestauranteMapper;
import com.juanmlopez.webapp.domain.Restaurante;
import com.juanmlopez.webapp.exception.DaoException;
import com.juanmlopez.webapp.exception.ServiceException;

import com.juanmlopez.webapp.service.impl.NegocioRestauranteServiceImpl;


@RestController
@RequestMapping(value = "v1/restaurante")
public class RestauranteController {
	
	@Autowired
	private NegocioRestauranteServiceImpl restauranteService;
	
	@GetMapping("/{restauranteId}")
	public @ResponseBody RestauranteDTO getRestaurante(@Valid @PathVariable Long restauranteId) throws ServiceException, DaoException {
		return RestauranteMapper.makeRestauranteDTO(restauranteService.findById(restauranteId));
	}
	
	@GetMapping(value = "/all")
	public List<RestauranteDTO> getResource() throws ServiceException, DaoException {

		List<RestauranteDTO> custList = restauranteService.findAll().stream().map(b -> RestauranteMapper.makeRestauranteDTO(b))
				.collect(Collectors.toList());

		return custList;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody RestauranteDTO createRestaurante(@Valid @RequestBody RestauranteDTO restauranteDTO)
			throws ServiceException, DaoException {
		Restaurante restaurante = RestauranteMapper.makeRestaurante(restauranteDTO);
		return RestauranteMapper.makeRestauranteDTO(restauranteService.saveOrUpdate(restaurante));
	}
	

	@GetMapping
	public RestauranteDTO getRestauranteByName(@RequestParam String nombre) throws ServiceException, DaoException {
		return RestauranteMapper.makeRestauranteDTO(restauranteService.findByNombre(nombre));
	}


	@PutMapping("/{restauranteId}")
	public @ResponseBody ResponseEntity<String> put(@Valid @PathVariable Long restauranteId, @RequestBody Map<String, String> data) throws ServiceException {
		RestauranteDTO rDTO= new RestauranteDTO();
		
		rDTO.setId(restauranteId);
		rDTO.setNombre(data.get("nombre"));
		rDTO.setDescripcion(data.get("descripcion"));
		rDTO.setDireccion(data.get("direccion"));
		
		Restaurante restaurante = RestauranteMapper.makeRestaurante(rDTO);
	
		RestauranteMapper.makeRestauranteDTO(restauranteService.saveOrUpdate(restaurante));
		
	    return new ResponseEntity<String>("PUT Response", HttpStatus.OK);
	}
	
	@DeleteMapping("/{restauranteId}")
	public void deleteBoard(@Valid @PathVariable Long restauranteId) throws ServiceException, DaoException {
		
		restauranteService.deleteRestaurante(restauranteId);
	}

}
