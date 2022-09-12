package com.portfolio.backend.controller;

import com.portfolio.backend.dto.EducationDto;
import com.portfolio.backend.model.Education;
import com.portfolio.backend.security.controller.GralMessage;
import com.portfolio.backend.service.EducationServ;
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
@RequestMapping("/education")
@CrossOrigin(origins = "http://localhost:4200")
public class educationCont {
    @Autowired
    EducationServ educationServ;
    
    @GetMapping("/list")
    public ResponseEntity<Education> list(){
        List<Education> list = educationServ.list();
        return new ResponseEntity(list, HttpStatus.OK);
        
    }
    @GetMapping("/detail/{id}")
    public ResponseEntity<Education> getById(@PathVariable("id") int id){
        if(!educationServ.existsById(id))
            return new ResponseEntity(new GralMessage("Doesn't exists"), HttpStatus.NOT_FOUND);
        Education education = educationServ.getOne(id).get();
        return new ResponseEntity(education, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!educationServ.existsById(id)){
            return new ResponseEntity(new GralMessage("It does not exists"), HttpStatus.NOT_FOUND);
        }
        educationServ.delete(id);
        return new ResponseEntity(new GralMessage("education eliminated"), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody EducationDto educationDto) {
        if (StringUtils.isBlank(educationDto.getNameE())) {
            return new ResponseEntity(new GralMessage("This field is required"), HttpStatus.BAD_REQUEST);
        }
        if(educationServ.existsByNameE(educationDto.getNameE()))
            return new ResponseEntity(new GralMessage("Already exists"),HttpStatus.BAD_REQUEST);
        Education education = new Education(educationDto.getNameE(), educationDto.getDescriptionE());
        educationServ.save(education);
        return new ResponseEntity(new GralMessage("Successful operation"), HttpStatus.OK);
    }
        
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody EducationDto educationDto) {
        if(!educationServ.existsById(id))
            return new ResponseEntity(new GralMessage("Doesn't exists"), HttpStatus.NOT_FOUND);
        //expendable
        if(educationServ.existsByNameE(educationDto.getNameE()) && educationServ.getByNameE(educationDto.getNameE()).get().getId() != id)
            return new ResponseEntity(new GralMessage("Already exists"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(educationDto.getNameE()))
            return new ResponseEntity(new GralMessage("This field is required"),HttpStatus.BAD_REQUEST);
        Education education = educationServ.getOne(id).get();
        education.setNameE(educationDto.getNameE());
        education.setDescriptionE(educationDto.getDescriptionE());
        educationServ.save(education);     
        return new ResponseEntity(new GralMessage("Successful operation"), HttpStatus.OK);        
    }
    
    
}
