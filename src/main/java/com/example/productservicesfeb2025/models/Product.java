package com.example.productservicesfeb2025.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "products") //will create a table from model. not necessary to give name in bracket.
// if not provided, model name will be taken as table name.



//As we can't access Private classes directly, we can use Getter-Setter method to Get or Set the changes.
// ANd Lombok provides Getter-setter methods without writing multiple lines of code (Auto)
public class Product extends BaseModel {
    private String title;
    private String description;
    private double price;
    private String imageURL;

    @ManyToOne
    private Category category;

}
