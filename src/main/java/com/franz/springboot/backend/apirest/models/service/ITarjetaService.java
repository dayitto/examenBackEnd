package com.franz.springboot.backend.apirest.models.service;

import java.util.List;

import com.franz.springboot.backend.apirest.models.entity.Tarjeta;

public interface ITarjetaService {
	public List<Tarjeta> findAll();

	public void save(Tarjeta tarjeta);
	
	public Tarjeta findOne(Long id);
	
	public void delete(Tarjeta tarjeta);
}
