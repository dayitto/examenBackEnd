package com.franz.springboot.backend.apirest.models.service;

import java.util.List;

import com.franz.springboot.backend.apirest.models.entity.Actividad;

public interface IActividadService {
	public List<Actividad> findAll();

	public void save(Actividad actividad);
	
	public Actividad findOne(Long id);
	
	public void delete(Actividad actividad);
}
