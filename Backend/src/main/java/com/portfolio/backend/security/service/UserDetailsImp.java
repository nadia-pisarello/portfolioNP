package com.portfolio.backend.security.service;

import com.portfolio.backend.model.Admin;
import com.portfolio.backend.model.GralUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsImp implements UserDetailsService{
    @Autowired
    GralUserService gralUserS;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        GralUser gralUser = gralUserS.getByUserName(userName).get();
        return Admin.build(gralUser);
    }
    
    
}
