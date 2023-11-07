package com.moviles.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.moviles.entity.Jefe;
import com.moviles.service.JefeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/jefe")
@RequiredArgsConstructor
public class JefeController {
	
	@Autowired
	private JefeService servicio;
	
	@GetMapping(value = "listado")
	@ResponseBody
	public ResponseEntity<List<Jefe>> listar(){
		List<Jefe> lista = servicio.listarJefes();
		return ResponseEntity.ok(lista);
	}
	
	@PostMapping("/grabar")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> insertaDocente(@RequestBody Jefe obj) {
		Map<String, Object> salida = new HashMap<>();
		try {
			obj.setCodigo(0);
			Jefe objSalida =  servicio.grabarActualizaJefe(obj);
			if (objSalida == null) {
				salida.put("mensaje", "No se registró, consulte con el administrador.");
			} else {
				salida.put("mensaje", "Se registró correctamente el Jefe.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje","No se registró, consulte con el administrador.");
		}
		return ResponseEntity.ok(salida);
	}

	@PutMapping("/actualiza")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> actualizaDocente(@RequestBody Jefe obj) {
		Map<String, Object> salida = new HashMap<>();
		try {
			Jefe objSalida =  servicio.grabarActualizaJefe(obj);
			if (objSalida == null) {
				salida.put("mensaje", "No se actualizó, consulte con el administrador.");
			} else {
				salida.put("mensaje","Se actualizó el Jefe correctamente.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", "No se actualizó, consulte con el administrador.");
		}
		return ResponseEntity.ok(salida);
	}
	
	
	@DeleteMapping("/elimina/{id}")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> eliminaDocente(@PathVariable("id") int id) {
		Map<String, Object> salida = new HashMap<>();
		try {
			servicio.eliminaJefe(id);
			salida.put("mensaje", "Se elimino el Jefe correctamente.");
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", "No se eliminó, consulte con el administrador.");
		}
		return ResponseEntity.ok(salida);
	}

}
