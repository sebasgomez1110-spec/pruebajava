package com.crudbasico.app.repository;

import com.crudbasico.app.model.Entrenador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntrenadorRepository extends JpaRepository<Entrenador, Long> {
}