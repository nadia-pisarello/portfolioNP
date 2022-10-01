package com.portfolio.backend.controller;

import com.portfolio.backend.dto.MessageCustom;
import com.portfolio.backend.dto.SkillDto;
import com.portfolio.backend.model.Skills;
import com.portfolio.backend.service.SkillsServ;
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
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/skills")
public class SkillControl {
    @Autowired
    SkillsServ skillS;
    
    @GetMapping("/list")
    public ResponseEntity<Skills> list() {
        List<Skills> list = skillS.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody SkillDto SkillDto) {
        if (StringUtils.isBlank(SkillDto.getName())) {
            return new ResponseEntity(new MessageCustom("This field is required"), HttpStatus.BAD_REQUEST);
        }
        //expendable
        if(skillS.existsByName(SkillDto.getName()))
            return new ResponseEntity(new MessageCustom("Already exists"),HttpStatus.BAD_REQUEST);
        Skills Skills = new Skills(SkillDto.getName());
        skillS.save(Skills);
        return new ResponseEntity(new MessageCustom("Successful operation"), HttpStatus.OK);
    }
     @GetMapping("/detail/{id}")
    public ResponseEntity<Skills> getById(@PathVariable("id") int id){
        if(!skillS.existsById(id))
            return new ResponseEntity(new MessageCustom("Doesn't exists"), HttpStatus.NOT_FOUND);
        Skills Skills = skillS.getOne(id).get();
        return new ResponseEntity(Skills, HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody SkillDto SkillDto) {
        if(!skillS.existsById(id))
            return new ResponseEntity(new MessageCustom("Doesn't exists"), HttpStatus.NOT_FOUND);
        //expendable
        if(skillS.existsByName(SkillDto.getName()) && skillS.getByName(SkillDto.getName()).get().getId() != id)
            return new ResponseEntity(new MessageCustom("Already exists"), HttpStatus.BAD_REQUEST);
        
        if(StringUtils.isBlank(SkillDto.getName()))
            return new ResponseEntity(new MessageCustom("This field is required"),HttpStatus.BAD_REQUEST);
        Skills Skills = skillS.getOne(id).get();
        skillS.save(Skills);
                
        return new ResponseEntity(new MessageCustom("Successful operation"), HttpStatus.OK);
        
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!skillS.existsById(id)) {
            return new ResponseEntity(new MessageCustom("Doesn't exists"), HttpStatus.NOT_FOUND);
        }
        skillS.delete(id);
        return new ResponseEntity(new MessageCustom("Successful operation"), HttpStatus.OK);
    }
    
    
}
