package com.ivjo.ms.proyectos.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ivjo.ms.proyectos.domain.Usuario;
import java.util.*;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	Optional<Usuario> findByEmail(String email);
}
