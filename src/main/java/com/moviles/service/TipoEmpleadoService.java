package com.moviles.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moviles.entity.TipoEmpleado;
import com.moviles.repository.TipoEmpleadoRepository;

@Service
public class TipoEmpleadoService {

	
	@Autowired
	private TipoEmpleadoRepository repository;
	
	
	public List<TipoEmpleado> listarTipos(){
		return repository.findAll();
	}
}
