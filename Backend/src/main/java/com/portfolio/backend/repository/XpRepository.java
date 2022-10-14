package com.portfolio.backend.repository;

import com.portfolio.backend.model.WorkXp;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface XpRepository extends JpaRepository<WorkXp,Long>{
    public Optional<WorkXp> findByXpName (String xpName);
    public boolean existsByXpName (String xpName);
        
}
