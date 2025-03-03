package com.example.productservicesfeb2025.services;

import com.example.productservicesfeb2025.exception.ProductNotFoundException;
import com.example.productservicesfeb2025.models.Category;
import com.example.productservicesfeb2025.models.Product;
import com.example.productservicesfeb2025.repository.CategoryRepository;
import com.example.productservicesfeb2025.repository.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("selfProductService")

public class SelfProductService implements ProductService {
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    public SelfProductService(ProductRepository productRepository, CategoryRepository categoryRepository){
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
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

    @Override
    public Product createProduct(Product product) {
        Category category = product.getCategory();
        //Before saving a product, we need to check whether the category already present in the DB or not
        //If yes, then no problem. Else we need to save the category first in DB

        Optional <Category> optionalCategory = categoryRepository.findByName(category.getName());

        if(optionalCategory.isEmpty()){
            //save the category
            category = categoryRepository.save(category);
        }
        product.setCategory(category);

        return productRepository.save(product);
    }

    @Override
    public Product replaceProduct(Long id, Product product) throws ProductNotFoundException {

        Optional <Product> productOptional = productRepository.findById(id);
        if(productOptional.isEmpty()) {
            throw new ProductNotFoundException("Product with id: " + id + " doesn't exist");
        }

        Product productFromDB = productOptional.get();
        productFromDB.setTitle(product.getTitle());
        productFromDB.setDescription(product.getDescription());
        productFromDB.setPrice(product.getPrice());
        productFromDB.setImageURL(product.getImageURL());

        Category category = product.getCategory();
        if(category.getId() == null) {
            //save the category first

            category = categoryRepository.save(category);
        }
        productFromDB.setCategory(category);

        return productRepository.save(productFromDB);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
