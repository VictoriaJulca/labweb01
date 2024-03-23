package com.ivjo.ms.proyectos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ivjo.ms.proyectos.domain.ProyectoInvestigacion;
import com.ivjo.ms.proyectos.services.ProyectoInvestigacionService;

@RestController
@RequestMapping("/api/v1/proyectoinvestigacion")
public class ProyectoInvestigacionController {
	@Autowired
	private ProyectoInvestigacionService pryService;
	
	@GetMapping
	public List<ProyectoInvestigacion> listarPryInvestigacion(){
		return pryService.listarTodoInv();
	}
	
	@GetMapping ("/{id}")
	public ProyectoInvestigacion listarPorId(@PathVariable Long id) {
		return pryService.buscarPorIdPry(id);
	}
	
	@PostMapping
	public ProyectoInvestigacion crearPryInv(@RequestBody ProyectoInvestigacion pryinv) {
		return pryService.grabar(pryinv);
	}
	
	@PutMapping("/{id}")
	public ProyectoInvestigacion editarPryInv(@PathVariable Long id, @RequestBody ProyectoInvestigacion pryinv) {
		ProyectoInvestigacion invDB=pryService.buscarPorIdPry(id);

		invDB.setEstadoPry(pryinv.getEstadoPry());
		invDB.setFechaCierrePry(pryinv.getFechaCierrePry());
		invDB.setFechaInicioPry(pryinv.getFechaInicioPry());
		invDB.setPresupuestoPry(pryinv.getPresupuestoPry());
		invDB.setResponsable(pryinv.getResponsable());
		
		return pryService.grabar(invDB);
	}
	
	@DeleteMapping("/{id}")
	public void eliminarPryInv(@PathVariable Long id) {
		pryService.eliminar(id);
	}

}
