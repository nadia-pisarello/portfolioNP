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
    
    public List<Skills> listSkill(){
        return skillsRepo.findAll();
    }
    
    public Optional<Skills> getOne(Long id){
        return skillsRepo.findById(id);
    }
    
    public Optional<Skills> getByName(String tech){
        return skillsRepo.findByTech(tech);
    }
    
    public void save(Skills skill){
        skillsRepo.save(skill);
    }
    
    public void delete(Long id){
        skillsRepo.deleteById(id);
    }
    
    public boolean existsById(Long id){
        return skillsRepo.existsById(id);
    }
    
    public boolean existsByName(String tech){
        return skillsRepo.existsByTech(tech);
    }
}
