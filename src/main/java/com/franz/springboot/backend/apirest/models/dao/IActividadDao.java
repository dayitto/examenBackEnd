package com.franz.springboot.backend.apirest.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.franz.springboot.backend.apirest.models.entity.Actividad;

public interface IActividadDao  extends CrudRepository<Actividad, Long>{
	
}
