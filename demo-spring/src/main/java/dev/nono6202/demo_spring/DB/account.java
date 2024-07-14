package dev.nono6202.demo_spring.DB;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class account {
    @Id public String id;
    public String pw;
}
