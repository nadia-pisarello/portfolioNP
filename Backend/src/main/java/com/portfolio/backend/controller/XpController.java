package com.portfolio.backend.controller;

import com.portfolio.backend.model.MessageCustom;
import com.portfolio.backend.dto.WorkDto;
import com.portfolio.backend.model.WorkXp;
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
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
public class XpController {

    @Autowired
    XpService xpService;

    @GetMapping("/experience/list")
    public ResponseEntity<List<WorkXp>> list() {
        List<WorkXp> list = xpService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @PostMapping("/experience")
    public ResponseEntity<?> create(@RequestBody WorkDto workDto) {
        WorkXp workXp = new WorkXp(workDto.getXpName(), workDto.getDescripXp());
        xpService.saveXp(workXp);
        return new ResponseEntity(new MessageCustom("Successful operation"), HttpStatus.OK);
    }
    
    @GetMapping("/experience/{id}")
    public ResponseEntity<WorkXp> getById(@PathVariable("id") Long id){
        if(!xpService.existsById(id))
            return new ResponseEntity(new MessageCustom("Doesn't exists"), HttpStatus.NOT_FOUND);
        WorkXp workXp = xpService.getOne(id);
        return new ResponseEntity(workXp, HttpStatus.OK);
    }
    
    @PutMapping("/experience/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody WorkDto workDto) {
        if(!xpService.existsById(id))
            return new ResponseEntity(new MessageCustom("Doesn't exists"), HttpStatus.NOT_FOUND);

        if(xpService.existsByNameXp(workDto.getXpName()) && xpService.getByNameXp(workDto.getXpName()).get().getXpId().equals(id))
            return new ResponseEntity(new MessageCustom("Already exists"), HttpStatus.BAD_REQUEST);
        
        if(StringUtils.isBlank(workDto.getXpName()))
            return new ResponseEntity(new MessageCustom("This field is required"),HttpStatus.BAD_REQUEST);
        WorkXp workXp = xpService.getOne(id);
        workXp.setXpName(workDto.getXpName());
        workXp.setDescripXp(workDto.getDescripXp());
        xpService.saveXp(workXp);
                
        return new ResponseEntity(new MessageCustom("Successful operation"), HttpStatus.OK);
        
    }
    
    @DeleteMapping("/experience/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        if (!xpService.existsById(id)) {
            return new ResponseEntity(new MessageCustom("Doesn't exists"), HttpStatus.NOT_FOUND);
        }
        xpService.deleteXp(id);
        return new ResponseEntity(new MessageCustom("Successful operation"), HttpStatus.OK);
    }
    
}
