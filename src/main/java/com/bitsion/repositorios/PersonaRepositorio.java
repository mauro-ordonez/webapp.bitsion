package com.bitsion.repositorios;

import java.util.List;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bitsion.modelo.Persona;

@Repository
public interface PersonaRepositorio extends RepositorioBase <Persona, Long>{
	
	@Query(value ="SELECT p FROM Persona p WHERE p.nombre LIKE %:nombre%")
	List<Persona> buscarPorNombre (@Param("nombre") String nombre); 
}