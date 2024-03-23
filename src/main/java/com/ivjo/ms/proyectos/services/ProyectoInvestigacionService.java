package com.ivjo.ms.proyectos.services;

import java.util.List;
import com.ivjo.ms.proyectos.domain.ProyectoInvestigacion;

public interface ProyectoInvestigacionService {
	List<ProyectoInvestigacion> listarTodoInv();
	ProyectoInvestigacion buscarPorIdPry(Long idPry);
	ProyectoInvestigacion grabar(ProyectoInvestigacion proyectoinvestigacion);
	ProyectoInvestigacion actualizar(ProyectoInvestigacion proyectoinvestigacion,Long idPry);
	void eliminar(Long idPry);
	ProyectoInvestigacion findByTitulo (String titulo);
}
