package com.ivjo.ms.proyectos.services;

import java.util.*;

import com.ivjo.ms.proyectos.domain.Investigador;
import com.ivjo.ms.proyectos.exception.EntityNotFoundException;
import com.ivjo.ms.proyectos.exception.IllegalOperationException;

public interface InvestigadorService {
	List<Investigador> listarTodos();
	Investigador buscarPorId(Long id);
	Investigador grabar(Investigador investigdor) throws IllegalOperationException;
	Investigador actualizar(Investigador investigador,Long id) throws EntityNotFoundException, IllegalOperationException;
	void eliminar(Long id) throws EntityNotFoundException, IllegalOperationException;
	Investigador findByDni(String dni);
	Investigador findByEmail (String email);
}
