package com.portfolio.backend.controller;

import com.portfolio.backend.model.User;
import com.portfolio.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("users/get/profile")
    public User getUser(Long userId){
        return userService.getUser(userId);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/users/create")
    public String createUser(@RequestBody User user){
        userService.createUser(user);
        return "Account created";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/users/edit/{userId}")
    public User editUser(@PathVariable Long userId,
                               @RequestParam("Name") String newName,
                               @RequestParam("LastName") String newLastName,
                               @RequestParam("image") String newImage){
        User user = userService.getUser(userId);
        
        user.setName(newName);
        user.setLastName(newLastName);
        user.setImage(newImage);
        userService.createUser(user);
        return user;
    }
    //@PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/users/delete/{userId}")
    public String deleteUser(@PathVariable Long userId){
        userService.deleteUser(userId);
        return "Successful operation";
    }
   }
