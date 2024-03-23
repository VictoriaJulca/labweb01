package com.ivjo.ms.proyectos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ivjo.ms.proyectos.domain.Usuario;
import com.ivjo.ms.proyectos.repositorios.UsuarioRepository;

@Service
public class UsuarioServiceImp implements UsuarioService {
	@Autowired
	private UsuarioRepository usuRep;
	
	@Override
	@Transactional
	public List<Usuario> listarTodosUsuario() {
		return usuRep.findAll();
		// TODO Auto-generated method stub
		//return null;
	}

	@Override
	@Transactional
	public Usuario BuscarPorId(Long id) {
		Optional <Usuario> usuario=usuRep.findById(id);
		return usuario.get();
		// TODO Auto-generated method stub
		//return null;
	}

	@Override
	@Transactional
	public Usuario grabar(Usuario usuario) {
		return usuRep.save(usuario);
		// TODO Auto-generated method stub
		//return null;
	}

	@Override
	@Transactional
	public Usuario actualizar(Usuario usuario, Long id) {
		usuario.setId(id);
		return usuRep.save(usuario);
		// TODO Auto-generated method stub
		//return null;
	}

	@Override
	@Transactional
	public void eliminar(Long id) {
		usuRep.deleteById(id);
		// TODO Auto-generated method stub

	}

	@Override
	@Transactional
	public Usuario findByEmail(String email) {
		Optional <Usuario> usu= usuRep.findByEmail(email);
		return usu.get();
		// TODO Auto-generated method stub
		//return null;
	}

}
