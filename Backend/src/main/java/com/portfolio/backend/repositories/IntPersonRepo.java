package com.portfolio.backend.repositories;

import com.portfolio.backend.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IntPersonRepo extends JpaRepository<Person,Long> {
    
}
