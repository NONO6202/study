package dev.nono6202.demo_spring.DB;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface accountRep extends JpaRepository<account, String>{
    @Query("select pw from account a where a.id = :id") String checkpw(@Param("id") String id);
}