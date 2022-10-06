package com.portfolio.backend.security.Controller;

import com.portfolio.backend.dto.JwtDto;
import com.portfolio.backend.model.LoginUser;
import com.portfolio.backend.model.MessageCustom;
import com.portfolio.backend.model.NewUser;
import com.portfolio.backend.model.Rol;
import com.portfolio.backend.model.User;
import com.portfolio.backend.security.Enums.RolName;
import com.portfolio.backend.security.jwt.Provider;
import com.portfolio.backend.service.RolService;
import com.portfolio.backend.service.UserService;

import java.util.*;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.password.PasswordEncoder;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin
public class AuthController {
    @Autowired PasswordEncoder passwordEncoder;
    
    @Autowired AuthenticationManager authenticationManager;

    @Autowired UserService userService;

    @Autowired
    RolService rolService;

    @Autowired
    Provider jwtProvider;

    @PostMapping("/auth/newUser")
    public ResponseEntity<?> newUSer(@Valid @RequestBody NewUser newUser, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return new ResponseEntity<>(new MessageCustom("campos mal puestos o email inválido"), HttpStatus.BAD_REQUEST);
        
        if(userService.existsByUserName(newUser.getUserName()))
            return new ResponseEntity(new MessageCustom("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        
        if(userService.existsByEmail(newUser.getEmail()))
            return new ResponseEntity(new MessageCustom("ese email ya existe"), HttpStatus.BAD_REQUEST);
        
        User user = new User(newUser.getName(), newUser.getUserName(), newUser.getEmail(),passwordEncoder.encode(newUser.getPassword()));
        
        Set<Rol> roles = new HashSet<>();
        roles.add(rolService.getByRolName(RolName.ROLE_USER).get());
        
        if(newUser.getRoles().contains("admin"))
            roles.add(rolService.getByRolName(RolName.ROLE_ADMIN).get());
        user.setRoles(roles);
        userService.save(user);
        return new ResponseEntity(new MessageCustom("User guardado"), HttpStatus.CREATED);
    }

    @PostMapping("/auth/login")
    public ResponseEntity<JwtDto> login(@Valid @RequestBody LoginUser loginUser, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return new ResponseEntity(new MessageCustom("campos mal puestos"), HttpStatus.BAD_REQUEST);
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUser.getUserName(), loginUser.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwtToken = jwtProvider.generateToken(authentication);
        UserDetails userDetails = (UserDetails)authentication.getPrincipal();
        JwtDto jwtDto = new JwtDto(jwtToken, userDetails.getUsername(), userDetails.getAuthorities());
        return new ResponseEntity(jwtDto, HttpStatus.OK);
    }
}
