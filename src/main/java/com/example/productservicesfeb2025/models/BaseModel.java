package com.example.productservicesfeb2025.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ValueGenerationType;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Getter
@Setter
@MappedSuperclass //No table for BaseModel class, but all the attrs of BaseModel
//will be present all the child class tables.

public class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // AUTO INCREMENT
    private Long id;
}
