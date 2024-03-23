package com.ivjo.ms.proyectos.services;

import java.util.List;

import com.ivjo.ms.proyectos.domain.Usuario;

public interface UsuarioService {
	List <Usuario>listarTodosUsuario();
	Usuario BuscarPorId(Long id);
	Usuario grabar(Usuario usuario);
	Usuario actualizar(Usuario usuario, Long id);
	void eliminar(Long id);
	Usuario findByEmail (String email);
}
