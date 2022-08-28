/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.backend.controller;

import com.portfolio.backend.dto.WorkDto;
import com.portfolio.backend.model.WorkXp;
import com.portfolio.backend.security.controller.GralMessage;
import com.portfolio.backend.service.XpService;
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
@RequestMapping("workXp")
@CrossOrigin(origins = "http://localhost:4200")
public class XpController {

    @Autowired
    XpService xpService;

    @GetMapping("/xp/list")
    public ResponseEntity<WorkXp> list() {
        List<WorkXp> list = xpService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @PostMapping("/xp/create")
    public ResponseEntity<?> create(@RequestBody WorkDto workDto) {
        if (StringUtils.isBlank(workDto.getXpName())) {
            return new ResponseEntity(new GralMessage("This field is required"), HttpStatus.BAD_REQUEST);
        }
        //expendable
        /*if(xpService.existsByNameXp(workDto.getXpName()))
            return new ResponseEntity(new GralMessage("Already exists"),HttpStatus.BAD_REQUEST);*/
        WorkXp workXp = new WorkXp(workDto.getXpName(), workDto.getDescripXp());
        xpService.saveXp(workXp);
        return new ResponseEntity(new GralMessage("Successful operation"), HttpStatus.OK);
    }
     @GetMapping("/xp/detail/{id}")
    public ResponseEntity<WorkXp> getById(@PathVariable("id") int id){
        if(!xpService.existsById(id))
            return new ResponseEntity(new GralMessage("Don't exists"), HttpStatus.NOT_FOUND);
        WorkXp workXp = xpService.getOne(id).get();
        return new ResponseEntity(workXp, HttpStatus.OK);
    }
    
    @PutMapping("/xp/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody WorkDto workDto) {
        if(!xpService.existsById(id))
            return new ResponseEntity(new GralMessage("Don't exists"), HttpStatus.BAD_REQUEST);
        //expendable
        /*if(xpService.existsByNameXp(workDto.getXpName()) && xpService.getByNameXp(workDto.getXpName()).get().getXpId() != id)
            return new ResponseEntity(new GralMessage("Already exists"), HttpStatus.BAD_REQUEST);
        */
        if(StringUtils.isBlank(workDto.getXpName()))
            return new ResponseEntity(new GralMessage("This field is required"),HttpStatus.BAD_REQUEST);
        WorkXp workXp = xpService.getOne(id).get();
        workXp.setDescripXp(workDto.getDescripXp());
        xpService.saveXp(workXp);
                
        return new ResponseEntity(new GralMessage("Successful operation"), HttpStatus.OK);
        
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!xpService.existsById(id)) {
            return new ResponseEntity(new GralMessage("Don't exists"), HttpStatus.NOT_FOUND);
        }
        xpService.deleteXp(id);
        return new ResponseEntity(new GralMessage("Successful operation"), HttpStatus.OK);
    }
}
