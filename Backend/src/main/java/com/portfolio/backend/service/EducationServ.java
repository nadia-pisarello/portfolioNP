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
    
    public List<Education> listEducation(){
        return educationR.findAll();
    }
    
    public Education getOne(Long id){
        return educationR.findById(id).orElse(null);
    }
    
     public Optional<Education> getByTitle(String title){
        return educationR.findByTitle(title);
    }
    
    public void save(Education education){
        educationR.save(education);
    }
        
    public void delete(Long id){
        educationR.deleteById(id);
    }   
    
    public boolean existsById(Long id){
        try{
            educationR.findById(id);
            return true;
        } catch(Exception e){
        return false;
        }
    }
    
    public boolean existsEducation(Long id){
        try{
            educationR.findById(id);
            return true;
        } catch (Exception e){
            return false;
        }
    }
    
    public boolean existsByTitle(String title){
        return educationR.existsByTitle(title);
    }
    
    public void editEducation (Long id, Education education){
         educationR.findById(id).map( editEducation -> {
         editEducation.setTitle(education.getTitle());
         editEducation.setInstitution(education.getInstitution());
         return educationR.save(editEducation);
      });
    }
}
