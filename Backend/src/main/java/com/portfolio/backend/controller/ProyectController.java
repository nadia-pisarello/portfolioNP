package com.portfolio.backend.controller;

import com.portfolio.backend.dto.ProyectDto;
import com.portfolio.backend.model.MessageCustom;
import com.portfolio.backend.model.Proyect;
import com.portfolio.backend.service.ProyectService;
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
public class ProyectController {

    @Autowired
    ProyectService proyectService;

    @GetMapping("/proyect/list")
    public ResponseEntity<List<Proyect>> list() {
        List<Proyect> list = proyectService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @PostMapping("/proyect")
    public ResponseEntity<?> create(@RequestBody ProyectDto proyectDto) {
        Proyect proyect = new Proyect(proyectDto.getTitle(), proyectDto.getDescription(), proyectDto.getImage());
        proyectService.save(proyect);
        return new ResponseEntity(new MessageCustom("Successful operation"), HttpStatus.OK);
    }

    @GetMapping("/proyect/{id}")
    public ResponseEntity<Proyect> getById(@PathVariable("id") Long id) {
        if (!proyectService.existsById(id)) {
            return new ResponseEntity(new MessageCustom("Doesn't exists"), HttpStatus.NOT_FOUND);
        }
        Proyect proyect = proyectService.getOne(id);
        return new ResponseEntity(proyect, HttpStatus.OK);
    }

    @PutMapping("/proyect/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody ProyectDto proyectDto) {
        if (!proyectService.existsById(id)) {
            return new ResponseEntity(new MessageCustom("Doesn't exists"), HttpStatus.NOT_FOUND);
        }
        //expendable
        if (proyectService.existsByTitle(proyectDto.getTitle()) && proyectService.getByTitle(proyectDto.getTitle()).get().getId().equals(id)) {
            return new ResponseEntity(new MessageCustom("Already exists"), HttpStatus.BAD_REQUEST);
        }

        if (StringUtils.isBlank(proyectDto.getTitle())) {
            return new ResponseEntity(new MessageCustom("This field is required"), HttpStatus.BAD_REQUEST);
        }
        Proyect proyect = proyectService.getOne(id);
        proyect.setTitle(proyectDto.getTitle());
        proyect.setDescription(proyectDto.getDescription());
        proyect.setImage(proyectDto.getImage()); 
        proyectService.save(proyect);

        return new ResponseEntity(new MessageCustom("Successful operation"), HttpStatus.OK);

    }
    
     @DeleteMapping("/proyect/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        if (!proyectService.existsById(id)) {
            return new ResponseEntity(new MessageCustom("Doesn't exists"), HttpStatus.NOT_FOUND);
        }
        proyectService.delete(id);
        return new ResponseEntity(new MessageCustom("Successful operation"), HttpStatus.OK);
    }
}
