package com.portfolio.backend.dto;

import java.util.HashSet;
import java.util.Set;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class NewUser {
    @NotBlank
    private String name;
    @NotBlank
    private String userName;
    @Email
    private String email;
    @NotBlank
    private String password;
    private Set <String> roles = new HashSet <> ();
    
    //Getters && Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

    public NewUser() {
    }

    public NewUser(String name, String userName, String email, String password) {
        this.name = name;
        this.userName = userName;
        this.email = email;
        this.password = password;
    }
    
    
    
}
