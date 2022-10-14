package com.portfolio.backend.service;

import com.portfolio.backend.model.WorkXp;
import com.portfolio.backend.repository.XpRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class XpService {
    @Autowired
    XpRepository xpRepository;
    
    public List<WorkXp> list(){
        return xpRepository.findAll();
    }
    
    public WorkXp getOne(Long id){
        return xpRepository.findById(id).orElse(null);
    }
    
    public Optional<WorkXp> getByNameXp(String nameXp){
        return xpRepository.findByXpName(nameXp);
    }
    
    public void saveXp(WorkXp workXp){
        xpRepository.save(workXp);
    }
    
    public void deleteXp(Long id){
        xpRepository.deleteById(id);
    }
    
    public boolean existsById(Long id){
        try{
            xpRepository.findById(id);
            return true;
        } catch(Exception e){
            return false;
        }
    }
    
    public boolean existsByNameXp(String nameXp){
        return xpRepository.existsByXpName(nameXp);
    }
}
