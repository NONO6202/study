package dev.nono6202.demo_spring.DB;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface contentRep extends JpaRepository<content, String>{
    @Query("select kor from content") List<String> findkor();
    @Query("select kor,eng from content") List<List<String>> findall();
}