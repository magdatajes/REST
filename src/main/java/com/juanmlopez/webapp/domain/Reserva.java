package com.juanmlopez.webapp.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang3.Validate;

@Entity
@Table(name = "reserva")
public class Reserva {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@ManyToOne
	private Mesa mesa;

	@Column(name = "dia" /**, nullable = false**/)
	@Temporal(TemporalType.DATE)
	private Date dia;

	@Column(name = "personas")
	private int personas;

	@ManyToOne
	@JoinColumn(name = "restaurante", referencedColumnName = "nombre")
	private Restaurante restaurante;

	@Column(name = "localizador")
	private Long localizador;

	@ManyToOne
	@JoinColumn(name = "Turno", referencedColumnName = "descripcion")
	@Enumerated(value = EnumType.STRING)
	private Turno turno;

	public Reserva() {
	}

	public Reserva(Long localizador) {
	Validate.notNull(localizador);
	this.localizador=localizador;
}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Mesa getMesa() {
		return mesa;
	}

	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}

}
