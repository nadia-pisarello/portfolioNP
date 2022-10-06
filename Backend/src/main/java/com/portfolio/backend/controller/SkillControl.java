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
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class SkillControl {

    @Autowired
    SkillsServ skillServ;

    @GetMapping("/skills/list")
    public ResponseEntity<Skills> listSkill() {
        List<Skills> list = skillServ.listSkill();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @PostMapping("/skills/create")
    public ResponseEntity<?> create(@RequestBody SkillDto skillDto) {
        if (StringUtils.isBlank(skillDto.getName())) {
            return new ResponseEntity(new MessageCustom("This field is required"), HttpStatus.BAD_REQUEST);
        }
        //expendable
        if (skillServ.existsByName(skillDto.getName())) {
            return new ResponseEntity(new MessageCustom("Already exists"), HttpStatus.BAD_REQUEST);
        }
        Skills skills = new Skills(skillDto.getName(), skillDto.getImage());
        skillServ.save(skills);
        return new ResponseEntity(new MessageCustom("Successful operation"), HttpStatus.OK);
    }

    @GetMapping("/skills/detail/{id}")
    public ResponseEntity<Skills> getById(@PathVariable("id") Long id) {
        if (!skillServ.existsById(id)) {
            return new ResponseEntity(new MessageCustom("Doesn't exists"), HttpStatus.NOT_FOUND);
        }
        Skills skills = skillServ.getOne(id).get();
        return new ResponseEntity(skills, HttpStatus.OK);
    }

    @PutMapping("/skills/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody SkillDto skillDto) {
        if (!skillServ.existsById(id)) {
            return new ResponseEntity(new MessageCustom("Doesn't exists"), HttpStatus.NOT_FOUND);
        }
        if (skillServ.existsByName(skillDto.getName()) && skillServ.getByName(skillDto.getName()).get().getId().equals(id)) {
            return new ResponseEntity(new MessageCustom("Already exists"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(skillDto.getName())) {
            return new ResponseEntity(new MessageCustom("This field is required"), HttpStatus.BAD_REQUEST);
        }
        Skills skills = skillServ.getOne(id).get();
        skills.setName(skillDto.getName());
        skills.setImage(skillDto.getImage());
        skillServ.save(skills);

        return new ResponseEntity(new MessageCustom("Successful operation"), HttpStatus.OK);

    }

    @DeleteMapping("/skills/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        if (!skillServ.existsById(id)) {
            return new ResponseEntity(new MessageCustom("Doesn't exists"), HttpStatus.NOT_FOUND);
        }
        skillServ.delete(id);
        return new ResponseEntity(new MessageCustom("Successful operation"), HttpStatus.OK);
    }

}
