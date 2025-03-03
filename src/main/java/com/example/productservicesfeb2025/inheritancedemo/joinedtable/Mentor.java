package com.example.productservicesfeb2025.inheritancedemo.joinedtable;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity (name = "jt_mentors")
@PrimaryKeyJoinColumn(name = "userid")
public class Mentor extends User {
    private String companyName;
    private double avgRating;
}
