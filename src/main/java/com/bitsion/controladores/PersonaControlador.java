package com.bitsion.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bitsion.modelo.Persona;
import com.bitsion.servicios.PersonaServi;


@RestController
@RequestMapping(path = "api/v1/personas")
public class PersonaControlador extends ControladorBaseImpl<Persona, PersonaServi>{

	@Autowired
	private PersonaServi personajeServi;	
	
	
	@GetMapping("/filtrarNombre")
	public ResponseEntity<?> buscarPorNombre(@RequestParam String nombre) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(personajeServi.encontrarPorNombre(nombre));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{error\":\"Error.\"}");
		}
	}
		
}
