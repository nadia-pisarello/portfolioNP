package com.portfolio.backend.service;

import com.portfolio.backend.model.User;
import com.portfolio.backend.security.repository.UserRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService{
    @Autowired
    UserRepository userRepository;
    
    public Optional<User> getByUserName(String userName){
        return userRepository.findByUserName(userName);
    }
   
    public boolean existsByUserName(String userName){
        return userRepository.existsByUserName(userName);
    }
    
    public void save(User user){
        userRepository.save(user);
    }
    
    public boolean existsByEmail(String email){
        return userRepository.existsByEmail(email);
    }
    
   
}
