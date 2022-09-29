package com.portfolio.backend.model;

import com.portfolio.backend.security.Enums.Roles;
import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Role implements Serializable {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roleId;
    @NotNull
    @Enumerated(EnumType.STRING)
    private Roles roles;

    //Constructor
    public Role() {
    }

    public Role(Roles roles) {
        this.roles = roles;
    }
    //Getters & Setters
    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }
    
    
}
