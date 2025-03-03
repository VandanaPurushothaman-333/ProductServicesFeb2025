package com.example.productservicesfeb2025.controllers;

import com.example.productservicesfeb2025.exception.ProductNotFoundException;
import com.example.productservicesfeb2025.models.Product;
import com.example.productservicesfeb2025.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;
    public ProductController(@Qualifier("selfProductService") ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Long id) throws ProductNotFoundException {
//        System.out.println("Some Random Text !!!");
//
//        ResponseEntity <Product> responseEntity = null;
//
//        try {
//            Product product = productService.getProductById(id);
//            responseEntity = new ResponseEntity<>(product, HttpStatus.OK);
//        }
//        catch (ProductNotFoundException e){
//            System.out.println(e.getCause());
//            responseEntity = new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
//        }


        return productService.getProductById(id);


    }

    @GetMapping()
    public List<Product> getAllProducts()
    {
        return productService.getAllProducts();
    }

    @PostMapping()
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable ("id") Long productId,
                                 @RequestBody Product product) {
        return null;
    }

    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable ("id") Long productId,
                                  @RequestBody Product product) throws ProductNotFoundException {
        return productService.replaceProduct(productId, product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProduct(id);

    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<String> handleProductNotFoundException(ProductNotFoundException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.SERVICE_UNAVAILABLE);
    }
}
