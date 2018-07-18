package com.juanmlopez.webapp.controller.mapper;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.juanmlopez.webapp.controller.dto.ReservaDTO;
import com.juanmlopez.webapp.domain.Reserva;

public class ReservaMapper {
	
	public static Reserva makeReserva(ReservaDTO reservaDTO) {
		Reserva reserva= new Reserva();
	
		reserva.setId(reservaDTO.getId());
		Date fecha= new Date();
		Long localizador = fecha.getTime();
		
		reserva.setLocalizador(localizador);
		reserva.setPersonas(reservaDTO.getPersonas());
		reserva.setDia(reservaDTO.getDia());
	
		return reserva;
	}

	public static ReservaDTO makeReservaDTO(Reserva reserva) {
		ReservaDTO reservaDTO = new ReservaDTO();
		reservaDTO.setId(reserva.getId());
		reservaDTO.setLocalizador(reserva.getLocalizador());
		reservaDTO.setPersonas(reserva.getPersonas());
		reservaDTO.setDia(reserva.getDia());
		reservaDTO.setTurno(reserva.getTurno().getDescripcion());
		return reservaDTO;
	}

	public static List<ReservaDTO> makeBoardDTOList(Collection<Reserva> boards) {
		return boards.stream()
				.map(ReservaMapper::makeReservaDTO).collect(Collectors.toList());
	}

	public static List<Reserva> makeBoardList(Collection<ReservaDTO> reservaDTO) {
		if (reservaDTO == null) {
			return Collections.emptyList();
		}
		return reservaDTO.stream().map(ReservaMapper::makeReserva).collect(Collectors.toList());
	}

}
