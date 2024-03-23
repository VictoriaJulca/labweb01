package com.ivjo.ms.proyectos.repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ivjo.ms.proyectos.domain.*;

public interface ProyectoRepository extends JpaRepository<ProyectoInvestigacion, Long> {

	Optional<ProyectoInvestigacion> findByTitulo (String titulo); 
}
