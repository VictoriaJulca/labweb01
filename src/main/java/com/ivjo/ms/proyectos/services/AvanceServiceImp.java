package com.ivjo.ms.proyectos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ivjo.ms.proyectos.domain.AvanceProyecto;
import com.ivjo.ms.proyectos.repositorios.AvanceRepository;

@Service
public class AvanceServiceImp implements AvanceService {
	@Autowired
	private AvanceRepository invAvc;
	
	@Override
	@Transactional
	public List<AvanceProyecto> listarTodoAvance() {
		return invAvc.findAll();
		// TODO Auto-generated method stub
		//return null;
	}

	@Override
	@Transactional
	public AvanceProyecto buscarPorId(Long id) {
		Optional <AvanceProyecto> avance=invAvc.findById(id);
		return avance.get();
		// TODO Auto-generated method stub
		//return null;
	}

	@Override
	@Transactional
	public AvanceProyecto grabar(AvanceProyecto avance) {
		return invAvc.save(avance);
		// TODO Auto-generated method stub
		//return null;
	}

	@Override
	@Transactional
	public AvanceProyecto actualizar(AvanceProyecto avance, Long id) {
		avance.setIdAvance(id);
		return invAvc.save(avance);
		// TODO Auto-generated method stub
		//return null;
	}

	@Override
	@Transactional
	public void eliminar(Long id) {
		invAvc.deleteById(id);
		// TODO Auto-generated method stub

	}

}
