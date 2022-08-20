package com.portfolio.backend.security.service;

import com.portfolio.backend.model.Role;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.portfolio.backend.security.roles.Roles;
import java.util.Optional;
import com.portfolio.backend.security.repository.RoleRepoInterf;

@Service
@Transactional
public class roleService {
    @Autowired
    RoleRepoInterf roleRepository;
    public Optional<Roles> getByRoles(Role roleName){
        return roleRepository.findByRole(roleName);
    }
    public void save(Role role){
        roleRepository.save(role);
    }
}
