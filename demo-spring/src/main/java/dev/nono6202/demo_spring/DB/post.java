package dev.nono6202.demo_spring.DB;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class post {
    @Id public String content;
    public String title;
    public String tag;
    @CreationTimestamp public LocalDateTime date;
}
