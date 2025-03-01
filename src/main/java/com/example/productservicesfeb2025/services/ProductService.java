package com.example.productservicesfeb2025.services;

import com.example.productservicesfeb2025.exception.ProductNotFoundException;
import com.example.productservicesfeb2025.models.Product;

import java.util.List;

public interface ProductService {
    Product getProductById(Long id) throws ProductNotFoundException;
    List<Product> getAllProducts();
}
