package com.franz.springboot.backend.apirest.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.franz.springboot.backend.apirest.models.entity.Tarjeta;

public interface ITarjetaDao extends CrudRepository<Tarjeta, Long>{

}
