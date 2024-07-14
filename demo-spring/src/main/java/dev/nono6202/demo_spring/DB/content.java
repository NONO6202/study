package dev.nono6202.demo_spring.DB;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class content {
    @Id public String kor;
    public String eng;
}
