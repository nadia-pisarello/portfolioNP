package com.portfolio.backend.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Role {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roleId;
    @NotNull
    @Enumerated(EnumType.STRING)
    private com.portfolio.backend.security.roles.Roles roles;

    //Constructor
    public Role() {
    }

    public Role(com.portfolio.backend.security.roles.Roles roles) {
        this.roles = roles;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public com.portfolio.backend.security.roles.Roles getRoles() {
        return roles;
    }

    public void setRoles(com.portfolio.backend.security.roles.Roles roles) {
        this.roles = roles;
    }
    
    
}
