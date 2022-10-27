package com.portfolio.backend.controller;

import com.portfolio.backend.model.MessageCustom;
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
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
public class SkillControl {

    @Autowired
    SkillsServ skillServ;

    @GetMapping("/skill/list")
    public ResponseEntity<List<Skills>> listSkill() {
        List<Skills> list = skillServ.listSkill();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @PostMapping("/skill")
    public ResponseEntity<?> create(@RequestBody SkillDto skillDto) {
        if (StringUtils.isBlank(skillDto.getTech())) {
            return new ResponseEntity(new MessageCustom("This field is required"), HttpStatus.BAD_REQUEST);
        }
        if (skillServ.existsByName(skillDto.getTech())) {
            return new ResponseEntity(new MessageCustom("Already exists"), HttpStatus.BAD_REQUEST);
        }
        Skills skills = new Skills(skillDto.getTech(), skillDto.getImage());
        skillServ.save(skills);
        return new ResponseEntity(new MessageCustom("Successful operation"), HttpStatus.OK);
    }

    @GetMapping("/skill/{id}")
    public ResponseEntity<Skills> getById(@PathVariable("id") Long id) {
        if (!skillServ.existsById(id)) {
            return new ResponseEntity(new MessageCustom("Doesn't exists"), HttpStatus.NOT_FOUND);
        }
        Skills skills = skillServ.getOne(id).get();
        return new ResponseEntity(skills, HttpStatus.OK);
    }

    @PutMapping("/skill/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody SkillDto skillDto) {
        if (!skillServ.existsById(id)) {
            return new ResponseEntity(new MessageCustom("Doesn't exists"), HttpStatus.NOT_FOUND);
        }
        
        if (StringUtils.isBlank(skillDto.getTech())) {
            return new ResponseEntity(new MessageCustom("This field is required"), HttpStatus.BAD_REQUEST);
        }
        Skills skills = skillServ.getOne(id).get();
        skills.setTech(skillDto.getTech());
        skills.setImage(skillDto.getImage());
        skillServ.save(skills);

        return new ResponseEntity(new MessageCustom("Successful operation"), HttpStatus.OK);

    }

    @DeleteMapping("/skill/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        if (!skillServ.existsById(id)) {
            return new ResponseEntity(new MessageCustom("Doesn't exists"), HttpStatus.NOT_FOUND);
        }
        skillServ.delete(id);
        return new ResponseEntity(new MessageCustom("Successful operation"), HttpStatus.OK);
    }

}
