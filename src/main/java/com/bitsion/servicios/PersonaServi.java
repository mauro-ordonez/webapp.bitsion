package com.bitsion.servicios;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitsion.modelo.Persona;
import com.bitsion.repositorios.PersonaRepositorio;
import com.bitsion.repositorios.RepositorioBase;


@Service 
public class PersonaServi extends BaseServiImple<Persona ,Long> {

	@Autowired
	private PersonaRepositorio personaRepositorio;

	
	public PersonaServi(RepositorioBase<Persona, Long> repositorioBase) {
		super(repositorioBase);
		
	}

	
	@Transactional
    public List<Persona> encontrarPorNombre(String nombre){
		try {
			return personaRepositorio.buscarPorNombre(nombre);
		} catch (Exception e) {
			throw new MissingDataException(e);
		}	
	}
}
