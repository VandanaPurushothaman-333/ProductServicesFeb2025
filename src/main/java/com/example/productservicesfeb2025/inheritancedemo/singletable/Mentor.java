package com.example.productservicesfeb2025.inheritancedemo.singletable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity //won't create separate tables for each child class as we have already used discriminator type as Singletype
@DiscriminatorValue(value = "2")

public class Mentor extends User {
    private String companyName;
    private double avgRating;
}
