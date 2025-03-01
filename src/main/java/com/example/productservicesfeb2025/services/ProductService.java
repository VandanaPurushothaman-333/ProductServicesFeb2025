package com.example.productservicesfeb2025.services;

import com.example.productservicesfeb2025.models.Product;

import java.util.List;

public interface ProductService {
    Product getProductById(long id);
    List<Product> getAllProducts();
}
