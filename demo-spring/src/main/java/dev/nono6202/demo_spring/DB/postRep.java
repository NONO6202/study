package dev.nono6202.demo_spring.DB;

import org.springframework.data.jpa.repository.JpaRepository;

public interface postRep extends JpaRepository<post, String>{
    
}