package com.example.productservicesfeb2025.inheritancedemo.joinedtable;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity (name = "jt_instructors")
@PrimaryKeyJoinColumn(name = "userid")
public class Instructor extends User {
    private String specialization;
    private double avgRating;
}
