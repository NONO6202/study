package dev.nono6202.demo_spring.DB;

import java.util.List;
import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface postRep extends JpaRepository<post, String>{
    @Query("select content,title,link,tag,substance from post order by pdate DESC") List<List<String>> findtitle();
    @Query("select content,title,link,tag,substance from post a where a.content= :content order by pdate DESC") List<List<String>> findpost(@Param("content") String content);
    @Query("select pdate from post order by pdate DESC") List<LocalDateTime> finddateAll();
    @Query("select pdate from post a where a.content= :content order by pdate DESC") List<LocalDateTime> finddate(@Param("content") String content);
}