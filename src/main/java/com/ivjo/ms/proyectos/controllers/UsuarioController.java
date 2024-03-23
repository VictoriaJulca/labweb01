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

import com.ivjo.ms.proyectos.domain.Usuario;
import com.ivjo.ms.proyectos.services.UsuarioService;

@RestController
@RequestMapping("/api/v1/usuario")
public class UsuarioController {
	@Autowired
	private UsuarioService usuService;
	
	@GetMapping
	public List<Usuario> listarUsuario(){
		return usuService.listarTodosUsuario();
	}
	
	@GetMapping("/{id}")
	public Usuario listarPorId(@PathVariable Long id) {
		return usuService.BuscarPorId(id);
	}
	
	@PostMapping
	public Usuario crearUsuario(@RequestBody Usuario usuario) {
		return usuService.grabar(usuario);
	}
	
	@PutMapping ("/{id}")
	public Usuario editarUsuario(@PathVariable Long id, @RequestBody Usuario usu) {
		Usuario usuDB=usuService.BuscarPorId(id);
		usuDB.setEmail(usu.getEmail());
		usuDB.setPassword(usu.getPassword());
		usuDB.setRol(usu.getRol());
		return usuService.grabar(usuDB);
	}
	
	@DeleteMapping("/{id}")
	public void eliminarUsuario(@PathVariable Long id) {
		usuService.eliminar(id);
	}

}
