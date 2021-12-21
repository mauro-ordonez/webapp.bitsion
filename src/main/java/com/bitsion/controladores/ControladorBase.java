package com.bitsion.controladores;

import java.io.Serializable;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface ControladorBase <E, ID extends Serializable>{

	public ResponseEntity<?> getAll();
	public ResponseEntity<?> save(@RequestBody E entidad);
	public ResponseEntity<?> upDate(@PathVariable ID id,@RequestBody E entidad);
	public ResponseEntity<?> delete(@PathVariable ID id);
}
