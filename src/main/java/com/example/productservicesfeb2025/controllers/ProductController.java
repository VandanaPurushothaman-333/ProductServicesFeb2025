package com.example.productservicesfeb2025.controllers;

import com.example.productservicesfeb2025.models.Product;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") long id) {
    return null;
    }

    @GetMapping()
    public List<Product> getAllProducts() {
        return new ArrayList<>();
    }

    @PostMapping()
    public Product createProduct(@RequestBody Product product) {
        return null;
    }

    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable ("id") Long productId,
                                 @RequestBody Product product) {
        return null;
    }

    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable ("id") Long productId,
                                  @RequestBody Product product) {
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long id) {

    }
}
