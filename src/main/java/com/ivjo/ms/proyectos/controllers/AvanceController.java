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

import com.ivjo.ms.proyectos.domain.AvanceProyecto;
import com.ivjo.ms.proyectos.services.AvanceService;

@RestController
@RequestMapping("/api/v1/avance")
public class AvanceController {
	@Autowired
	private AvanceService avcService;
	
	@GetMapping
	public List<AvanceProyecto> listarAvance(){
		return avcService.listarTodoAvance();
	}
	
	@GetMapping("/{id}")
	public AvanceProyecto listarPorId(@PathVariable Long id) {
		return avcService.buscarPorId(id);
	}
	
	@PostMapping
	public AvanceProyecto crearAvance(@RequestBody AvanceProyecto avance) {
		return avcService.grabar(avance);
	}
	
	@PutMapping ("/{id}")
	public AvanceProyecto editarAvance(@PathVariable Long id, @RequestBody AvanceProyecto avc) {
		AvanceProyecto avcDB=avcService.buscarPorId(id);

		avcDB.setDescripcionAvance(avc.getDescripcionAvance());
		avcDB.setEstadoAv(avc.getEstadoAv());
		avcDB.setFechaRegAvance(avc.getFechaRegAvance());
		avcDB.setPresupuestoGastado(avc.getPresupuestoGastado());
		avcDB.setPresupuestoPry(avc.getPresupuestoPry());
		return avcService.grabar(avcDB);
	}
	
	@DeleteMapping ("/{id}")
	public void  eliminarAvance(@PathVariable Long id) {
		avcService.eliminar(id);
	}
}
