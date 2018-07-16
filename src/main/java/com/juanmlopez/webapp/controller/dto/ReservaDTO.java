package com.juanmlopez.webapp.controller.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.juanmlopez.webapp.domain.Mesa;
import com.juanmlopez.webapp.domain.Restaurante;
import com.juanmlopez.webapp.domain.Turno;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReservaDTO {

	private Long id;

	private Mesa mesa;

	private Date dia;

	private int personas;

	private Restaurante restaurante;

	private Long localizador;

	private Turno turno;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Mesa getMesa() {
		return mesa;
	}

	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}

	public Date getDia() {
		return dia;
	}

	public void setDia(Date dia) {
		this.dia = dia;
	}

	public int getPersonas() {
		return personas;
	}

	public void setPersonas(int personas) {
		this.personas = personas;
	}

	public Restaurante getRestaurante() {
		return restaurante;
	}

	public void setRestaurante(Restaurante restaurante) {
		this.restaurante = restaurante;
	}

	public Long getLocalizador() {
		return localizador;
	}

	public void setLocalizador(Long localizador) {
		this.localizador = localizador;
	}

	public Turno getTurno() {
		return turno;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
	}
}
