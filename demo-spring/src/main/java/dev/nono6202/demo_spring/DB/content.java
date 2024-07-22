package dev.nono6202.demo_spring.DB;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class content {
    public Integer num;
    @Id public String link;
    public String appearance;
    public String introduction;
}