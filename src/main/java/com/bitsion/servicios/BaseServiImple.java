package com.bitsion.servicios;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;

import com.bitsion.repositorios.RepositorioBase;

public abstract class BaseServiImple <E, ID extends Serializable> implements BaseServi<E, Long> {
 
	protected RepositorioBase<E, Long> repositorioBase;

	public BaseServiImple(RepositorioBase<E, Long> repositorioBase) {
		this.repositorioBase = repositorioBase;
	}
	
	@Override
	@Transactional
	public List<E> finAll()  {
		try {
			List<E> personajes = repositorioBase.findAll();
			return personajes;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	@Transactional
	public E save( E entidad)  {
		try {
			return repositorioBase.save(entidad);			
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	@Transactional
	public E upDate(Long id, E entidad)  {
		try {
			Optional<E> entidadOpcional = repositorioBase.findById(id);
			E ent = entidadOpcional.get();
			ent = repositorioBase.save(entidad);
			return ent;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	@Transactional
	public boolean delete(Long id)  {
		try {
			if(repositorioBase.existsById(id)) {
				repositorioBase.deleteById(id);
				return true;
			}else {
				throw new Exception("persona no existe");
			}

		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
	
	

}
