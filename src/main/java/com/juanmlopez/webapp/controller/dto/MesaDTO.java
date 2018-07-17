package com.juanmlopez.webapp.controller.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.juanmlopez.webapp.domain.Restaurante;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MesaDTO {

	private int id;

	private Restaurante restaurante;


	private int capacidad;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Restaurante getRestaurante() {
		return restaurante;
	}

	public void setRestaurante(Restaurante restaurante) {
		this.restaurante = restaurante;
	}


	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

}
