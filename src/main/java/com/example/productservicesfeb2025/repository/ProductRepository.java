package com.example.productservicesfeb2025.repository;

import com.example.productservicesfeb2025.models.Product;
import com.example.productservicesfeb2025.projections.ProductWithTitleAndPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Override
    Optional<Product> findById(Long productId);
    //"optional" is forced by JPA, if not throws error

    @Override
    List<Product> findAll();

    Optional<Product> findByTitleContains(String str);
    // SELECT * FROM PRODUCTS WHERE TITLE LIKE '%str%'

    Optional<Product> findByCategory_Id(Long categoryId);

    @Override
    Product save(Product product);

    @Override
    void deleteById(Long id);

    //if we want to fetch data from products table like this:
    // select title, price from products where id = 10
    // HQL --> Hibernate Query Language --> Based on models

//    @Query("select p.title, p.price from products p where p.title = :title and p.price = :price")
//
//    List<ProductWIthTitleAndPrice> getProductWIthTitleAndPrice (String title, Double price);

    @Query(value = "select p.title, p.price from products p where p.title = :title and p.price = :price", nativeQuery = true)

    List<ProductWithTitleAndPrice> getProductWIthTitleAndPriceSQL (String title, Double price);

    // SQL --> Native Query
}

