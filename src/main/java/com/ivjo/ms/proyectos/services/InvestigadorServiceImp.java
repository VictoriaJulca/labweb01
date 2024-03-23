package com.ivjo.ms.proyectos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ivjo.ms.proyectos.domain.Investigador;
import com.ivjo.ms.proyectos.exception.EntityNotFoundExceptionMessages;
import com.ivjo.ms.proyectos.exception.IllegalOperationException;
import com.ivjo.ms.proyectos.repositorios.InvestigadorRepository;

import jakarta.persistence.EntityNotFoundException;
@Service

public class InvestigadorServiceImp implements InvestigadorService {
	@Autowired 
	private InvestigadorRepository invRep;
		
	@Override
	@Transactional
	public List<Investigador> listarTodos() {
		return invRep.findAll();
		// TODO Auto-generated method stub
		//return null;
	}

	@Override
	@Transactional
	public Investigador buscarPorId(Long id) throws EntityNotFoundException{
		Optional<Investigador> investigador=invRep.findById(id);
		if(investigador.isEmpty()) throw new EntityNotFoundException(EntityNotFoundExceptionMessages.INVESTIGADOR_NOT_FOUND);
		return investigador.get();
		// TODO Auto-generated method stub
		//return null;
	}

	@Override
	@Transactional
	public Investigador grabar(Investigador investigador) throws IllegalOperationException{
		if(!invRep.findByEmail(investigador.getEmail()).isEmpty()) {
			throw new IllegalOperationException("Ya existe un investigador con ese email");
		}
		if(!invRep.findByDni(investigador.getDni()).isEmpty()) {
			throw new IllegalOperationException("Ya existe un investigador con ese dni");
		}
		return invRep.save(investigador);
		//return invRep.save(investigdor);
		// TODO Auto-generated method stub
		//return null;
	}

	@Override
	@Transactional
	public Investigador actualizar(Investigador investigador, Long id) throws EntityNotFoundException, IllegalOperationException {
		Optional<Investigador>invEntity=invRep.findById(id);
		if(invEntity.isEmpty()) {
			throw new EntityNotFoundException("El investigador no existe");
		}
		if(!invRep.findByEmail(investigador.getEmail()).isEmpty()) {
			throw new IllegalOperationException("El investigador ya existe");
		}
		if(!invRep.findByDni(investigador.getDni()).isEmpty()) {
			throw new IllegalOperationException("El DNI del investigador ya existe");
		}
		investigador.setIdInvestigador(id);
		return invRep.save(investigador);
		// TODO Auto-generated method stub
		//return null;
	}

	@Override
	@Transactional
	public void eliminar(Long id) throws EntityNotFoundException, IllegalOperationException{
		Investigador inv=invRep.findById(id).orElseThrow(
				()->new EntityNotFoundException(EntityNotFoundExceptionMessages.INVESTIGADOR_NOT_FOUND)
				);
		// TODO Auto-generated method stub
		invRep.deleteById(id);

	}

	@Override
	@Transactional
	public Investigador findByDni(String dni) {
		Optional<Investigador> inv= invRep.findByEmail(dni);
		if(inv.isEmpty()) throw new EntityNotFoundException(EntityNotFoundExceptionMessages.INVESTIGADOR_NOT_FOUND);
		return inv.get();
		// TODO Auto-generated method stub
		//return null;
	}

	@Override
	@Transactional
	public Investigador findByEmail(String email) {
		Optional<Investigador> inv= invRep.findByEmail(email);
		if(inv.isEmpty()) throw new EntityNotFoundException(EntityNotFoundExceptionMessages.INVESTIGADOR_NOT_FOUND);
		return inv.get();
		// TODO Auto-generated method stub
		//return null;
	}

}
