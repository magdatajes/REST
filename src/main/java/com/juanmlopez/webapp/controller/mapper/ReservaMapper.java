package com.juanmlopez.webapp.controller.mapper;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.juanmlopez.webapp.controller.dto.ReservaDTO;
import com.juanmlopez.webapp.domain.Reserva;

public class ReservaMapper {

	public static Reserva makeReserva(ReservaDTO reservaDTO) {
		return new Reserva();
	}

	public static ReservaDTO makeReservaDTO(Reserva reserva) {
		ReservaDTO reservaDTO = new ReservaDTO();
		reservaDTO.setId(reserva.getId());
		reservaDTO.setLocalizador(reserva.getLocalizador());
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
