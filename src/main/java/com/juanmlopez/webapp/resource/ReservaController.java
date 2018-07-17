package com.juanmlopez.webapp.resource;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.juanmlopez.webapp.controller.dto.ReservaDTO;
import com.juanmlopez.webapp.controller.mapper.ReservaMapper;
import com.juanmlopez.webapp.domain.Reserva;
import com.juanmlopez.webapp.exception.DaoException;
import com.juanmlopez.webapp.exception.ServiceException;
import com.juanmlopez.webapp.service.impl.NegocioRestauranteServiceImpl;

@RestController
@RequestMapping(value = "v1/reservas")
public class ReservaController {
	
	@Autowired
	private NegocioRestauranteServiceImpl restauranteService;
	
	@GetMapping(value = "/all")
	public List<ReservaDTO> getResource() throws ServiceException, DaoException {

		List<ReservaDTO> custList = restauranteService.findAllReservas().stream().map(b -> ReservaMapper.makeReservaDTO(b))
				.collect(Collectors.toList());

		return custList;
	}
	
	@GetMapping("/{reservaLocalizador}")
	public @ResponseBody ReservaDTO getReserva(@Valid @PathVariable Long reservaLocalizador) throws ServiceException, DaoException {
		return ReservaMapper.makeReservaDTO(restauranteService.findByLocalizador(reservaLocalizador));
	}
	
	@DeleteMapping("/{localizador}")
	public void deleteReserva(@Valid @PathVariable Long localizador) throws ServiceException, DaoException {
		restauranteService.deleteReservaByLocalizador(localizador);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody ReservaDTO createReserva(@Valid @RequestBody ReservaDTO reservaDTO) throws ServiceException {
		Reserva reserva = ReservaMapper.makeReserva(reservaDTO);
		return ReservaMapper.makeReservaDTO(restauranteService.saveOrUpdateReserva(reserva));
	}
}
