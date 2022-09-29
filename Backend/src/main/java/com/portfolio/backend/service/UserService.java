package com.portfolio.backend.service;

import com.portfolio.backend.model.User;
import com.portfolio.backend.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements ServiceInterface{
    @Autowired
    UserRepository userRepository;
    @Override
    public User getUser(Long idUser){
        User user = userRepository.findById(idUser).orElse(null);
        return user;
    }
    @Override
    public void createUser(User user){
        userRepository.save(user);
    }
    
    @Override
    public void deleteUser(Long idUser){
        userRepository.deleteById(idUser);
    }
    
    @Override
    public List<User> getAllUsers() {
        List<User> user = userRepository.findAll();
        return user;
    }
}
