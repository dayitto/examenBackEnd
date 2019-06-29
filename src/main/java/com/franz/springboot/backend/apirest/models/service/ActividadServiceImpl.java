package com.franz.springboot.backend.apirest.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.franz.springboot.backend.apirest.models.dao.IActividadDao;
import com.franz.springboot.backend.apirest.models.entity.Actividad;

@Service
public class ActividadServiceImpl implements IActividadService{
	
	@Autowired
	private IActividadDao actividadDao;

	@Override
	@Transactional(readOnly=true)
	public List<Actividad> findAll() {
		return (List<Actividad>) actividadDao.findAll();
	}

	@Override
	@Transactional()
	public void save(Actividad actividad) {
		actividadDao.save(actividad);
	}

	@Override
	@Transactional(readOnly=true)
	public Actividad findOne(Long id) {
		return actividadDao.findById(id).orElse(null);
	}

	@Override
	@Transactional()
	public void delete(Actividad actividad) {
		actividadDao.delete(actividad);
	}

}
