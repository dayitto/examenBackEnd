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

import com.franz.springboot.backend.apirest.models.entity.Actividad;
import com.franz.springboot.backend.apirest.models.service.IActividadService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class ActividadRestController {
	
	@Autowired
	private IActividadService actividadService;
	
	@GetMapping("/actividades")
	public List<Actividad> index(){
		return actividadService.findAll();
	}

	@GetMapping("/actividades/{id}")
	public Actividad show(@PathVariable Long id) {
		return actividadService.findOne(id);
	}
	
	@PostMapping("/actividades")
	@ResponseStatus(HttpStatus.CREATED)
	public Actividad create(@RequestBody Actividad actividad) {
		actividadService.save(actividad);
		return actividad;
	}
	
	@PutMapping("/actividades/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Actividad update(@RequestBody Actividad actividad,@PathVariable Long id) {
		
		Actividad actividadActual=actividadService.findOne(id);
		actividadActual.setDescripcion(actividad.getDescripcion() != null ? actividad.getDescripcion() : actividadActual.getDescripcion());
		actividadActual.setFecha(actividad.getFecha() != null ? actividad.getFecha() : actividadActual.getFecha());
		actividadActual.setHora(actividad.getHora() != null ? actividad.getHora() : actividadActual.getHora());
		actividadService.save(actividadActual);
		return actividadActual;
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/actividades/{id}")
	public void delete(@PathVariable Long id) {
		Actividad actividad = actividadService.findOne(id);
		actividadService.delete(actividad);
	}

}
