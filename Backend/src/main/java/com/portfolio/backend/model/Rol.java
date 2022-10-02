package com.portfolio.backend.model;

import com.portfolio.backend.security.Enums.RolName;
import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Rol implements Serializable {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId;
    @NotNull
    @Enumerated(EnumType.STRING)
    private RolName rolName;
    //Constructor
    public Rol() {
    }

    public Rol(RolName rolName) {
        this.rolName = rolName;
    }
    //Getters & Setters
    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public RolName getRolName() {
        return rolName;
    }

    public void setRolName(RolName rolName) {
        this.rolName = rolName;
    }

    public RolName getRoles() {
        return rolName;
    }

    public void setRoles(RolName rolName) {
        this.rolName = rolName;
    }
    
    
}
