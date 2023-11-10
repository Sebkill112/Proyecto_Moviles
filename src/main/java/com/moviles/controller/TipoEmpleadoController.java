package com.moviles.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.moviles.entity.TipoEmpleado;
import com.moviles.service.TipoEmpleadoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/tipos")
@RequiredArgsConstructor
public class TipoEmpleadoController {
	
	@Autowired
	private TipoEmpleadoService servicio;
	
	@GetMapping(value = "listado")
	@ResponseBody
	public ResponseEntity<List<TipoEmpleado>> listar(){
		List<TipoEmpleado> lista = servicio.listarTipos();
		return ResponseEntity.ok(lista);
	}

}
