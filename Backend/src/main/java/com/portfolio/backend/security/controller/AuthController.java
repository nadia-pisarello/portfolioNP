package com.portfolio.backend.security.controller;

import com.portfolio.backend.dto.JwtDto;
import com.portfolio.backend.dto.LoginUser;
import com.portfolio.backend.dto.NewUser;
import com.portfolio.backend.model.GralUser;
import com.portfolio.backend.model.Role;
import com.portfolio.backend.security.jwt.Provider;
import com.portfolio.backend.security.Enums.Roles;
import com.portfolio.backend.security.service.GralUserService;
import com.portfolio.backend.security.service.RoleService;
import java.util.HashSet;
import java.util.Set;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

    @Autowired
    PasswordEncoder passwordEnconder;
    @Autowired
    AuthenticationManager authManager;
    @Autowired
    GralUserService gralUserS;
    @Autowired
    RoleService roleServ;
    @Autowired
    Provider provider;

    @PostMapping("/newUser")
    public ResponseEntity<?> nuevo(@Valid @RequestBody NewUser newUser, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity(new GralMessage("invalid email or wrong fields"), HttpStatus.BAD_REQUEST);
        }
        if (gralUserS.existsByUserName(newUser.getUserName())) {
            return new ResponseEntity(new GralMessage("Username already exists"), HttpStatus.BAD_REQUEST);
        }
        if (gralUserS.existsByEmail(newUser.getEmail())) {
            return new ResponseEntity(new GralMessage("Email already exists"), HttpStatus.BAD_REQUEST);
        }
        GralUser gralUser = new GralUser(newUser.getName(), newUser.getUserName(), newUser.getEmail(), passwordEnconder.encode(newUser.getPassword()));
        Set<Role> role = new HashSet<>();
        role.add(roleServ.getByRoles(Roles.ROLE_USER).get());
        if (newUser.getRoles().contains("admin")) {
            role.add(roleServ.getByRoles(Roles.ROLE_ADMIN).get());
        }
        gralUser.setRoles(role);
        gralUserS.save(gralUser);
        return new ResponseEntity(new GralMessage("User has been saved"),HttpStatus.CREATED);
    } 
    
    @PostMapping("/login")
    public ResponseEntity<JwtDto> login(@Valid @RequestBody LoginUser loginUser, BindingResult bindingResult){
        if (bindingResult.hasErrors())
            return new ResponseEntity(new GralMessage("Wrong fields"), HttpStatus.BAD_REQUEST);
        Authentication auth = authManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginUser.getUserName(), loginUser.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(auth);
        String jwt = provider.generateToken(auth);
        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());
        
        return new ResponseEntity(jwtDto,HttpStatus.OK);
    }
}
