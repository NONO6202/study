package dev.nono6202.demo_spring.DB;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface postRep extends JpaRepository<post, String>{
    @Query("select content,title from post") List<List<String>> findtitle();
}