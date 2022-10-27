package com.portfolio.backend.service;

import com.portfolio.backend.model.Profile;
import com.portfolio.backend.repository.ProfileRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProfileService {

    @Autowired
    ProfileRepository profileRepo;

    public List<Profile> getProfileAll() {
        return profileRepo.findAll();
    }
    
        public Profile getOne(Long id){
        return profileRepo.findById(id).orElse(null);
    }

    public void createProfile(Profile profile) {
        profileRepo.save(profile);
    }

    public void delete(Long id) {
        profileRepo.deleteById(id);
    }

    public boolean existesById(Long id) {
        return profileRepo.existsById(id);
    }
    
    public Boolean existsProfile(Long id){
        try { profileRepo.findById(id);
            return true;
        } catch(Exception e){return false;}
                    
    }  

}