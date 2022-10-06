package com.portfolio.backend.controller;

import com.portfolio.backend.dto.EducationDto;
import com.portfolio.backend.model.MessageCustom;
import com.portfolio.backend.model.Education;
import com.portfolio.backend.service.EducationServ;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:4200") //@CrossOrigin(origins = "*") or 
public class EducationCont {
    @Autowired
    EducationServ educationServ;
    
    @GetMapping("/education/list")
    public ResponseEntity<List<Education>> listEducation(){
        List<Education> list = educationServ.listEducation();
        return new ResponseEntity(list, HttpStatus.OK);
        
    }
    @GetMapping("/education/{id}")
    public ResponseEntity<Education> getById(@PathVariable("id") Long id){
        if(!educationServ.existsById(id))
            return new ResponseEntity(new MessageCustom("Doesn't exists"), HttpStatus.NOT_FOUND);
        Education education = educationServ.getEducationById(id);
        return new ResponseEntity(education, HttpStatus.OK);
    }
    
    @DeleteMapping("/education/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        if(!educationServ.existsById(id)){
            return new ResponseEntity(new MessageCustom("It does not exists"), HttpStatus.NOT_FOUND);
        }
        educationServ.delete(id);
        return new ResponseEntity(new MessageCustom("Education eliminated"), HttpStatus.OK);
    }

    @PostMapping("/education")
    public ResponseEntity<?> create(@RequestBody EducationDto educationDto) {
        if (StringUtils.isBlank(educationDto.getTitle())) {
            return new ResponseEntity(new MessageCustom("This field is required"), HttpStatus.BAD_REQUEST);
        }
        Education education = new Education(educationDto.getTitle(), educationDto.getInstitution(), educationDto.getDescriptionE());
        educationServ.save(education);
        return new ResponseEntity(new MessageCustom("Successful operation"), HttpStatus.OK);
    }
        
    @PutMapping("/education/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody EducationDto educationDto) {
        if(!educationServ.existsEducation(id))
            return new ResponseEntity(new MessageCustom("Doesn't exists"), HttpStatus.NOT_FOUND);
        if(StringUtils.isBlank(educationDto.getTitle()))
            return new ResponseEntity(new MessageCustom("This field is required"),HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(educationDto.getInstitution()))
                return new ResponseEntity(new MessageCustom("This field is required"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(educationDto.getDescriptionE()))
            return new ResponseEntity(new MessageCustom("This field is required"), HttpStatus.BAD_REQUEST);
        Education education = educationServ.getEducationById(id);
        education.setTitle(educationDto.getTitle());
        education.setInstitution(educationDto.getInstitution());
        education.setDescriptionE(educationDto.getDescriptionE());
        educationServ.save(education);     
        return new ResponseEntity(new MessageCustom("Successful operation"), HttpStatus.OK);        
    }
    
    
}
