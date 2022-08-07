package com.portfolio.backend.service;

import com.portfolio.backend.model.User;
import com.portfolio.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    
    public User getUser(Long idUser){
        return userRepository.findById(idUser).orElse(null);
    }
    public User createUser(User user){
        return userRepository.save(user);
    }
    public User updateUser(Long idUser){
        User user = userRepository.getReferenceById(idUser);
        return user;
    }
    public String deleteUser(Long idUser){
        userRepository.deleteById(idUser);
        return "Successful operation";
    }
}
