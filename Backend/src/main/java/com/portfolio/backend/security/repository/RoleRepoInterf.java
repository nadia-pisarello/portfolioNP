package com.portfolio.backend.security.repository;

import com.portfolio.backend.model.Role;
import com.portfolio.backend.security.roles.Roles;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepoInterf extends JpaRepository<Role, Integer>{
    Optional<Roles> findByRole (Role role);
}
