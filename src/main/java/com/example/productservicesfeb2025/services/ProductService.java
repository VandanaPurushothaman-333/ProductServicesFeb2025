package com.example.productservicesfeb2025.services;

import com.example.productservicesfeb2025.exception.ProductNotFoundException;
import com.example.productservicesfeb2025.models.Product;

import java.util.List;

public interface ProductService {
    Product getProductById(Long id) throws ProductNotFoundException;
    List<Product> getAllProducts();
    Product createProduct (Product product);
    Product replaceProduct (Long id, Product product) throws ProductNotFoundException;
    void deleteProduct(Long id);
}
