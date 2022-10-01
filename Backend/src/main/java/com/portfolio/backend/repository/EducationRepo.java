package com.portfolio.backend.repository;

import com.portfolio.backend.model.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationRepo extends JpaRepository<Education, Long>{
    
}
