package com.portfolio.backend.service;

import com.portfolio.backend.model.Proyect;
import com.portfolio.backend.repository.ProyectRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProyectService {
    @Autowired
    ProyectRepository proyectRepo;
    
    public List<Proyect> list(){
        return proyectRepo.findAll();
    }
    
     public Proyect getOne(Long id){
        return proyectRepo.findById(id).orElse(null);
    }
    
    public Optional<Proyect> getByTitle(String title){
        return proyectRepo.findByTitle(title);
    }
     
    public void save(Proyect Proyect){
        proyectRepo.save(Proyect);
    }
        
    public void delete(Long id){
        proyectRepo.deleteById(id);
    } 
        
    public boolean existsById(Long id){
        try{
            proyectRepo.findById(id);
            return true;
        } catch (Exception e){
        return false;
        }
    }
    
    public boolean existsProyect(Long id){
        try{
            proyectRepo.findById(id);
            return true;
        } catch (Exception e){
            return false;
        }
    }
    
    public boolean existsByTitle(String title){
        return proyectRepo.existsByTitle(title);
    }
    
    public void editProyect (Long id, Proyect proyect){
         proyectRepo.findById(id).map( editProyect -> {
         editProyect.setTitle(proyect.getTitle());
         editProyect.setDescription(proyect.getDescription());
         editProyect.setImage(proyect.getImage());
         return proyectRepo.save(editProyect);
      });
    }
}
