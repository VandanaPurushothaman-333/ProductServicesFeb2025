package com.example.productservicesfeb2025.inheritancedemo.tableperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "tbc_tas")
public class TA extends User {
    private int numberOfHR;
}
