package com.portfolio.backend.security.Enums;

public enum RolName {
    ROLE_ADMIN("admin"), ROLE_USER("user");
    
    private final String rol;

    public String getRol() {
        return rol;
    }
    
    private RolName(String rol){
        this.rol = rol;
    }

    public static RolName getROLE_ADMIN() {
        return ROLE_ADMIN;
    }

    public static RolName getROLE_USER() {
        return ROLE_USER;
    }
    
    

}

