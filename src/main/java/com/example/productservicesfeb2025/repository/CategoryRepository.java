package com.example.productservicesfeb2025.repository;

import com.example.productservicesfeb2025.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    Optional<Category> findByName(String name);

    //Select * from category where name = ?
    @Override
    Category save(Category category);
}
