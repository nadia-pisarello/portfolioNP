package com.portfolio.backend.security.repository;

import com.portfolio.backend.model.Rol;
import com.portfolio.backend.security.Enums.RolName;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer>{
    Optional<Rol> findByRolName (RolName rolName);
}
