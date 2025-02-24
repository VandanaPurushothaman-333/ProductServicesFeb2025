package com.example.productservicesfeb2025.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//As we can't access Private classes directly, we can use Getter-Setter method to Get or Set the changes.
// ANd Lombok provides Getter-setter methods without writing multiple lines of code (Auto)
public class Product extends BaseModel {
    private long id;
    private String name;
    private String title;
    private String description;
    private double price;
    private String imageURL;
    private Category category;

}
