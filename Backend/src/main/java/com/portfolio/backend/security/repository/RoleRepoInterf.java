package com.portfolio.backend.security.repository;

import com.portfolio.backend.model.Role;
import com.portfolio.backend.security.roles.Roles;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

//@Repository
@Service
public interface RoleRepoInterf extends JpaRepository<Role, Integer>{
    Optional<Role> findByRole (Roles roles);
}
