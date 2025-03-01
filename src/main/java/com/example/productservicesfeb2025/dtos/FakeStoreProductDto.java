package com.example.productservicesfeb2025.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

//datatypes are as per Fakestore link
public class FakeStoreProductDto {
    private long id;
    private String title;
    private String description;
    private double price;
    private String imageURL;
    private String category;


}
