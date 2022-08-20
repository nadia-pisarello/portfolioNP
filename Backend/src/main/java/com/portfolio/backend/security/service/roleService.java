package com.portfolio.backend.security.service;

import com.portfolio.backend.model.Role;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import com.portfolio.backend.security.repository.RoleRepoInterf;
import com.portfolio.backend.security.roles.Roles;

@Service
@Transactional
public class RoleService {
    @Autowired
    RoleRepoInterf roleRepository;
    public Optional<Role> getByRoles(Roles roleName){
        return roleRepository.findByRole(roleName);
    }
    public void save(Role role){
        roleRepository.save(role);
    }
}
