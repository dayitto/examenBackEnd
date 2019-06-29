package com.franz.springboot.backend.apirest.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.franz.springboot.backend.apirest.models.dao.ITarjetaDao;
import com.franz.springboot.backend.apirest.models.entity.Tarjeta;

@Service
public class TarjetaServiceImpl implements ITarjetaService {
	
	@Autowired
	private ITarjetaDao tarjetaDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<Tarjeta> findAll() {
		return (List<Tarjeta>) tarjetaDao.findAll();
	}

	@Override
	@Transactional()
	public void save(Tarjeta tarjeta) {
		tarjetaDao.save(tarjeta);
	}

	@Override
	@Transactional(readOnly=true)
	public Tarjeta findOne(Long id) {
		return tarjetaDao.findById(id).orElse(null);
	}

	@Override
	@Transactional()
	public void delete(Tarjeta tarjeta) {
		tarjetaDao.delete(tarjeta);
	}

}
