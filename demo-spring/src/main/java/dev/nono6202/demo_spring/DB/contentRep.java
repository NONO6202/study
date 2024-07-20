package dev.nono6202.demo_spring.DB;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface contentRep extends JpaRepository<content, String>{
    @Query("select num,link,appearance from content order by num") List<List<String>> findall();
    @Query("select link from content order by num") List<String> findlink();
    @Query("select count(link) from content") Integer colcount();

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("update content a set a.num = :num where a.link = :link") void updatenum(@Param("num") Integer num,@Param("link") String link);

}