package com.example.productservicesfeb2025.repository;

import com.example.productservicesfeb2025.models.Category;
import com.example.productservicesfeb2025.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository <Product, Long> {
    @Override
    Optional<Product> findById(Long productId);
    //"optional" is forced by JPA, if not throws error

    @Override
    List<Product> findAll();

   Optional<Product> findByTitleContains(String str);
   // SELECT * FROM PRODUCTS WHERE TITLE LIKE '%str%'

    Optional<Product> findByCategory_Id(Long categoryId);
}
