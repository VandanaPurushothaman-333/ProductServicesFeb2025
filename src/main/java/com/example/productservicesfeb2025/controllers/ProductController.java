package com.example.productservicesfeb2025.controllers;

import com.example.productservicesfeb2025.models.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {
    @GetMapping("/products/{Id}")
    public Product getProductById(long id) {

    }

}
