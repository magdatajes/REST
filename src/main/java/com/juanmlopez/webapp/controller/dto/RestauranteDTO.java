package com.juanmlopez.webapp.controller.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.juanmlopez.webapp.domain.Mesa;
import com.juanmlopez.webapp.domain.Reserva;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RestauranteDTO {

	private Long id;

	private String nombre;

	private String direccion;

	private String descripcion;

	private List<Mesa> mesas;

	private List<Reserva> reservas;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Mesa> getMesas() {
		return mesas;
	}

	public void setMesas(List<Mesa> mesas) {
		this.mesas = mesas;
	}

	public List<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

}
