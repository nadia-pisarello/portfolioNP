
package com.portfolio.backend.controller;

import com.portfolio.backend.dto.ProfileDto;
import com.portfolio.backend.model.MessageCustom;
import com.portfolio.backend.model.Profile;
import com.portfolio.backend.service.ProfileService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/api/v1")
@CrossOrigin(origins = "*")

public class ProfileController {
    
    @Autowired ProfileService profileServ;
    
    @GetMapping("/profile/getAll")
    public List<Profile> getProfile(){
        return profileServ.getProfile();
    }
    
    @PostMapping("/profile/create")
    public String createUser(@RequestBody Profile profile){
        profileServ.createProfile(profile);
        return "Successful operation";  
    }
    
    @DeleteMapping("/profile/delete/{id}")
    public String deleteProfile(@PathVariable Long id){
        profileServ.delete(id);
        return "Successful operation";
    }
        
    @PutMapping("/profile/update/{id}")
    public ResponseEntity<?> editProfile(@PathVariable Long id, @RequestBody ProfileDto profileDto){
        if(!profileServ.existsProfile(id)) return new ResponseEntity(new MessageCustom("It doesn't exists"), HttpStatus.NOT_FOUND);
        if(StringUtils.isBlank(profileDto.getName())) return new ResponseEntity(new MessageCustom("Field required"),HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(profileDto.getLastname())) return new ResponseEntity(new MessageCustom("Field required"),HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(profileDto.getPosition())) return new ResponseEntity(new MessageCustom("Field required"),HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(profileDto.getDescription())) return new ResponseEntity(new MessageCustom("Field required"),HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(profileDto.getImage())) return new ResponseEntity(new MessageCustom("Field required"),HttpStatus.BAD_REQUEST);
        Profile profile = profileServ.findProfile(id);
        profile.setName(profileDto.getName());
        profile.setLastname(profileDto.getLastname());
        profile.setPosition(profileDto.getPosition());
        profile.setDescription(profileDto.getDescription());
         profile.setImage(profileDto.getImage());
        profileServ.createProfile(profile);
        return new ResponseEntity(new MessageCustom("Successfull operation"), HttpStatus.OK);
    }   
       
    
    @GetMapping("/profile/getProfile")
    public Profile findProfile(){
        return profileServ.findProfile((long)1);
    }
}
