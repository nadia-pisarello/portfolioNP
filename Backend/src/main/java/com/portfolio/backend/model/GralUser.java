package com.portfolio.backend.model;

import java.util.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class GralUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int gUserId;
    @NotNull
    private String realName;
    @NotNull
    @Column(unique=true)
    private String userName;
    @NotNull
    private String email;
    @NotNull
    private String password;
    //create table
    @ManyToMany(fetch= FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name="user_id"),inverseJoinColumns = @JoinColumn(name= "role_id"))
    private Set<Role> roles = new HashSet<>();
    //constructor
    public GralUser() {
    }

    public GralUser(String realName, String userName, String email, String password) {
        this.realName = realName;
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

    public int getgUserId() {
        return gUserId;
    }

    public void setgUserId(int gUserId) {
        this.gUserId = gUserId;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
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

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
    
    
    
    
}
