package com.portfolio.backend.service;

import com.portfolio.backend.model.User;
import java.util.List;


public interface ServiceInterface {
    public List<User> getAllUsers();
    public User getUser(Long idUser);
    public void createUser(User user);
    public void deleteUser(Long id);
    
}
