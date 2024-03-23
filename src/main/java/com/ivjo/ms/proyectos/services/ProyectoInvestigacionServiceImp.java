package com.ivjo.ms.proyectos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ivjo.ms.proyectos.domain.ProyectoInvestigacion;
import com.ivjo.ms.proyectos.repositorios.ProyectoRepository;

@Service 
public class ProyectoInvestigacionServiceImp implements ProyectoInvestigacionService {

	@Autowired
	private ProyectoRepository pryRep;
	
	
	@Override
	@Transactional
	public List<ProyectoInvestigacion> listarTodoInv() {
		return pryRep.findAll();
		// TODO Auto-generated method stub
		//return null;
	}

	@Override
	@Transactional
	public ProyectoInvestigacion buscarPorIdPry(Long idPry) {
		Optional <ProyectoInvestigacion> proyectoinvestigacion=pryRep.findById(idPry);
		return proyectoinvestigacion.get();
		// TODO Auto-generated method stub
		//return null;
	}

	@Override
	@Transactional
	public ProyectoInvestigacion grabar(ProyectoInvestigacion proyectoinvestigacion) {
		return pryRep.save(proyectoinvestigacion);
		// TODO Auto-generated method stub
		//return null;
	}

	@Override
	@Transactional
	public ProyectoInvestigacion actualizar(ProyectoInvestigacion proyectoinvestigacion, Long idPry) {
		proyectoinvestigacion.setIdPryInv(idPry);
		return pryRep.save(proyectoinvestigacion);
		// TODO Auto-generated method stub
		//return null;
	}

	@Override
	@Transactional
	public void eliminar(Long idPry) {
		pryRep.deleteById(idPry);
		// TODO Auto-generated method stub

	}

	public ProyectoInvestigacion findByTitulo(String titulo) {
		Optional<ProyectoInvestigacion> pry=pryRep.findByTitulo(titulo);
		return pry.get();
		// TODO Auto-generated method stub
		//return null;
	}

}
