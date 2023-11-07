package com.moviles.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moviles.entity.Empleado;
import com.moviles.repository.EmpleadoRepository;

@Service
public class EmpleadoService {

	@Autowired
	private EmpleadoRepository repo;

	public List<Empleado> listarEmpleados() {

		return repo.findAll();
	}

	
	public Empleado grabarActualizaEmpleado(Empleado empleado) {
		return repo.save(empleado);
	}

	public void eliminaEmpleado(int id) {
		repo.deleteById(id);
	}

}
