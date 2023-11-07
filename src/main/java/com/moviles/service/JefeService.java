package com.moviles.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moviles.entity.Jefe;
import com.moviles.repository.JefeRepository;

@Service
public class JefeService {

	@Autowired
	private JefeRepository repo;

	public List<Jefe> listarJefes() {

		return repo.findAll();
	}

	
	public Jefe grabarActualizaJefe(Jefe Jefe) {
		return repo.save(Jefe);
	}

	public void eliminaJefe(int id) {
		repo.deleteById(id);
	}
}
