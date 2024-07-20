package dev.nono6202.demo_spring.DB;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class post {
    public String content;
    public String title;
    @Id public String link;
    public String tag;
    public String substance;
    @CreationTimestamp public LocalDateTime pdate;
}
