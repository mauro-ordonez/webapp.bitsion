package com.bitsion.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.bitsion.servicios.BaseServiImple;


public  abstract class ControladorBaseImpl <E, S extends BaseServiImple<E, Long>> implements ControladorBase<E, Long>{


	@Autowired
	protected S servicio;
	
	@GetMapping("/listar")
	public ResponseEntity<?> getAll() {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(servicio.finAll());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{error\":\"Error.\"}");
		}
	}
	@PostMapping("/guardar")
	public ResponseEntity<?> save(@RequestBody E entidad) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(servicio.save(entidad));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{error\":\"Error.\"}");
		}
	}
	
	@PutMapping("/guardar/{id}")
	public ResponseEntity<?> upDate(@PathVariable Long id, @RequestBody E entidad) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(servicio.upDate(id,entidad));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{error\":\"Error.\"}");
		}
	}
	
	@DeleteMapping("/borrar/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		try {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(servicio.delete(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{error\":\"Error.\"}");
		}
	}
	
}
