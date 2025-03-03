package com.example.productservicesfeb2025.services;

import com.example.productservicesfeb2025.exception.ProductNotFoundException;
import com.example.productservicesfeb2025.models.Product;
import com.example.productservicesfeb2025.repository.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("selfProductService")

public class SelfProductService implements ProductService {
    private ProductRepository productRepository;
    public SelfProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public Product getProductById(Long productId) throws ProductNotFoundException {
        //make a database call to get the product with given id
        //select * from products whee id = 1
        Optional <Product> optionalProduct = productRepository.findById(productId);
        if(optionalProduct.isEmpty()) {
            throw new ProductNotFoundException("Product with id: " + productId + " doesn't exist");
        }
        return optionalProduct.get();

    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }
}
