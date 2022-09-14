package com.portfolio.backend.repository;

import com.portfolio.backend.model.Skills;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillsRepo extends JpaRepository<Skills, Integer>{
    Optional<Skills> findByName(String name);
    public boolean existsByName(String name);
}
