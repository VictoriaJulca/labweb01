package com.ivjo.ms.proyectos.services;

import java.util.List;

import com.ivjo.ms.proyectos.domain.AvanceProyecto;

public interface AvanceService {
	List<AvanceProyecto> listarTodoAvance();
	AvanceProyecto buscarPorId(Long id);
	AvanceProyecto grabar(AvanceProyecto avance);
	AvanceProyecto actualizar(AvanceProyecto avance, Long id);
	void eliminar(Long id);
}
