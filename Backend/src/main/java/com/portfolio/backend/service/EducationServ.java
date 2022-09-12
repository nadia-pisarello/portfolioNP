package com.portfolio.backend.service;

import com.portfolio.backend.model.Education;
import com.portfolio.backend.repository.EducationRepo;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class EducationServ {
    @Autowired
    EducationRepo educationR;
    
    public List<Education> list(){
        return educationR.findAll();
    }
    
    public Optional<Education> getOne(int id){
        return educationR.findById(id);
    }
    
    public Optional<Education> getByNameE(String nameE){
        return educationR.findByNameE(nameE);
    }
    
    public void save(Education education){
        educationR.save(education);
    }
    
    public void delete(int id){
        educationR.deleteById(id);
    }
    
    public boolean existsById(int id){
        return educationR.existsById(id);
    }
    
    public boolean existsByNameE(String nameE){
        return educationR.existsByNameE(nameE);
    }
}
