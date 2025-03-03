package com.example.productservicesfeb2025.inheritancedemo.tableperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "tbc_instructors")
public class Instructor extends User {
    private String specialization;
    private double avgRating;
}
