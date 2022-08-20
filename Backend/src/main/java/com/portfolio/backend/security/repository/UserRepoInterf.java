
package com.portfolio.backend.security.repository;

import com.portfolio.backend.model.GralUser;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface UserRepoInterf extends JpaRepository<GralUser, Integer>{
    Optional<GralUser> findByUserName(String userName);
    boolean existsByUserName(String userName);
    boolean existsByEmail(String email);
    
}
