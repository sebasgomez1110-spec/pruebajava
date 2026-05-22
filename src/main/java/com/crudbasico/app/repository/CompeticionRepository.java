package com.crudbasico.app.repository;

import com.crudbasico.app.model.Competicion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompeticionRepository extends JpaRepository<Competicion, Long> {
}