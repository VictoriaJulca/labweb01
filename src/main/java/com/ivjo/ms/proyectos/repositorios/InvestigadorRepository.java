package com.ivjo.ms.proyectos.repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ivjo.ms.proyectos.domain.*;

public interface InvestigadorRepository extends JpaRepository<Investigador, Long> {
	Optional<Investigador> findByDni(String dni);
	Optional<Investigador> findByEmail (String email);
}
