package com.example.productservicesfeb2025.services;

import com.example.productservicesfeb2025.exception.ProductNotFoundException;
import com.example.productservicesfeb2025.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("SelfProductService")
public class SelfProductService implements ProductService {
    @Override
    public Product getProductById(Long id) throws ProductNotFoundException {
        //make a database call to get the product with given id
        //select * from products whee id = 1
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }
}
