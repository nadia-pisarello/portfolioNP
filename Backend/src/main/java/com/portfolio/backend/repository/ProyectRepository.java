package com.portfolio.backend.repository;

import com.portfolio.backend.model.Proyect;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyectRepository extends JpaRepository<Proyect, Long>{
    public Optional<Proyect> findByTitle (String titlee);
    public boolean existsByTitle (String title);
}
