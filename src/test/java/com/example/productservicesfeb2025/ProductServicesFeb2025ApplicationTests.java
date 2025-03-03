package com.example.productservicesfeb2025;

import com.example.productservicesfeb2025.projections.ProductWithTitleAndPrice;
import com.example.productservicesfeb2025.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ProductServicesFeb2025ApplicationTests {
    @Autowired
    private ProductRepository productRepository;

    @Test
    void contextLoads() {
        List<ProductWithTitleAndPrice> products =
                productRepository.getProductWIthTitleAndPriceSQL("Samsung Ear Buds" , 4500.0);
        for (ProductWithTitleAndPrice product : products) {
            System.out.println(product.getTitle() + " -> " + product.getPrice());
        }

    }

}
