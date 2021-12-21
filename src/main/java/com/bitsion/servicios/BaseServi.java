package com.bitsion.servicios;

import java.io.Serializable;
import java.util.List;

public interface BaseServi <E, ID extends Serializable>{

	public List<E> finAll();
	public E save(E entidad);
	public E upDate(Long id, E entidadad);
	public boolean delete(Long id);
}
