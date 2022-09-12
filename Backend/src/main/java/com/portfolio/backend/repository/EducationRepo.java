package com.portfolio.backend.repository;

import com.portfolio.backend.model.Education;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationRepo extends JpaRepository<Education, Integer>{
    public Optional<Education> findByNameE(String nameE);
    public boolean existsByNameE(String nameE);
}
