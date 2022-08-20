package com.portfolio.backend.model;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class Admin implements UserDetails{
    private String name;
    private String adminName;
    private String email;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    public Admin(String name, String adminName, String email, String password, Collection<? extends GrantedAuthority> authorities) {
        this.name = name;
        this.adminName = adminName;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
    }
    public static Admin build(GralUser gralUser){
        List<GrantedAuthority> authorities = gralUser.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getRoles().name()))
                .collect(Collectors.toList());
        return new Admin(gralUser.getRealName(),gralUser.getUserName(),
                gralUser.getEmail(),gralUser.getPassword(),authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }
    public String getName() {
        return name;
    }
    @Override
    public String getUsername() {
        return adminName;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


}
