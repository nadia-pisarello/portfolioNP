package com.portfolio.backend.service;

import com.portfolio.backend.model.Skills;
import com.portfolio.backend.repository.SkillsRepo;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class SkillsServ {
    @Autowired
    SkillsRepo skillsRepo;
    
    public List<Skills> list(){
        return skillsRepo.findAll();
    }
    
    public Optional<Skills> getOne(int id){
        return skillsRepo.findById(id);
    }
    
    public Optional<Skills> getByName(String name){
        return skillsRepo.findByName(name);
    }
    
    public void save(Skills skill){
        skillsRepo.save(skill);
    }
    
    public void delete(int id){
        skillsRepo.deleteById(id);
    }
    
    public boolean existsById(int id){
        return skillsRepo.existsById(id);
    }
    
    public boolean existsByName(String name){
        return skillsRepo.existsByName(name);
    }
}
