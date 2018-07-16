package com.juanmlopez.webapp.controller.mapper;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.juanmlopez.webapp.controller.dto.RestauranteDTO;
import com.juanmlopez.webapp.domain.Restaurante;

public class RestauranteMapper {

	public static Restaurante makeRestaurante(RestauranteDTO restauranteDTO) {
		return new Restaurante(restauranteDTO.getNombre());
	}

	public static RestauranteDTO makeRestauranteDTO(Restaurante restaurante) {
		RestauranteDTO restauranteDTO = new RestauranteDTO();
		restauranteDTO.setId(restaurante.getId());
		restauranteDTO.setNombre(restaurante.getNombre());
		return restauranteDTO;
	}

	public static List<RestauranteDTO> makeBoardDTOList(Collection<Restaurante> restaurantes) {
		return restaurantes.stream().map(RestauranteMapper::makeRestauranteDTO).collect(Collectors.toList());
	}

	public static List<Restaurante> makeBoardList(Collection<RestauranteDTO> restaurantesDTO) {
		if (restaurantesDTO == null) {
			return Collections.emptyList();
		}
		return restaurantesDTO.stream().map(RestauranteMapper::makeRestaurante).collect(Collectors.toList());
	}
}