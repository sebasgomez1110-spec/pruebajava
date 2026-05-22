package com.crudbasico.app.repository;

import com.crudbasico.app.model.Club;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClubRepository extends JpaRepository<Club, Long> {
}