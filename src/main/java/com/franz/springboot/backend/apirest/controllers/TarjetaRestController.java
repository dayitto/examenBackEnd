package com.franz.springboot.backend.apirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.franz.springboot.backend.apirest.models.entity.Tarjeta;
import com.franz.springboot.backend.apirest.models.service.ITarjetaService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class TarjetaRestController {
	
	@Autowired
	private ITarjetaService tarjetaService;
	
	@GetMapping("/tarjetas")
	public List<Tarjeta> index(){
		return tarjetaService.findAll();
	}

	@GetMapping("/tarjetas/{id}")
	public Tarjeta show(@PathVariable Long id) {
		return tarjetaService.findOne(id);
	}
	
	@PostMapping("/tarjetas")
	@ResponseStatus(HttpStatus.CREATED)
	public Tarjeta create(@RequestBody Tarjeta tarjeta) {
		tarjetaService.save(tarjeta);
		return tarjeta;
	}
	
	@PutMapping("/tarjetas/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Tarjeta update(@RequestBody Tarjeta tarjeta,@PathVariable Long id) {
		
		Tarjeta tarjetaActual=tarjetaService.findOne(id);
		tarjetaActual.setTipo(tarjeta.getTipo());
		tarjetaActual.setNumero(tarjeta.getNumero());
		tarjetaActual.setMes(tarjeta.getMes());
		tarjetaActual.setYear(tarjeta.getYear());
		tarjetaService.save(tarjetaActual);
		return tarjetaActual;
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/tarjetas/{id}")
	public void delete(@PathVariable Long id) {
		Tarjeta tarjeta = tarjetaService.findOne(id);
		tarjetaService.delete(tarjeta);
	}
}
