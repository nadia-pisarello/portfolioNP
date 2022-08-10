package com.portfolio.backend.service;

import com.portfolio.backend.model.User;


public interface ServiceInterface {
    public User getUser(Long idUser);
    public void createUser(User user);
    //public void updateUser(Long idUser);
    public void deleteUser(Long id);
    
}
