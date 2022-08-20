package com.portfolio.backend.security.service;

import com.portfolio.backend.model.GralUser;
import com.portfolio.backend.security.repository.UserRepoInterf;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class GralUserService {

    @Autowired
    UserRepoInterf userRepoI;
    public Optional<GralUser> getByUserName(String userName){
        return userRepoI.findByUserName(userName);
    }
    public boolean existsByUserName(String userName){
        return userRepoI.existsByUserName(userName);
    }
    public boolean existsByEmail(String email){
        return userRepoI.existsByEmail(email);
    }
    public void save(GralUser gralUser){
        userRepoI.save(gralUser);
    }
}
