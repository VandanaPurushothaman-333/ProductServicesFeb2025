package com.example.productservicesfeb2025.services;

import com.example.productservicesfeb2025.dtos.FakeStoreProductDto;
import com.example.productservicesfeb2025.models.Category;
import com.example.productservicesfeb2025.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service

public class FakeStoreProductService implements ProductService{
    //This service implementation uses Fakestore to fetch products from FakeStore

    private RestTemplate restTemplate;
    public FakeStoreProductService (RestTemplate restTemplate) { //Constructor
        //RestTemplate restTemplate is already present in the ioc container/application context
        // that object will get injected into this object reference
        this.restTemplate = restTemplate;
    }
    private Product convertFakeStoreProductDtoToProductDto(FakeStoreProductDto fakeStoreProductDto) {
        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setPrice(fakeStoreProductDto.getPrice());

        //one option
        //product.setCategory(new Category());
        //product.getCategory().setName(fakeStoreProductDto.getCategory());

        //second option
        Category category = new Category();
        product.setName(fakeStoreProductDto.getCategory());
        product.setCategory(category);

        return product;


    }

    @Override
    public Product getProductById(long productId) {
        //Make an API call to FakeStore and get the product with the given id
        //http://localhost:8080/products/10

        throw new RuntimeException("Something went wrong");
//        FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject("http://localhost:8080/products/" + productId,
//                FakeStoreProductDto.class);
        // output getting from this url needs to be mapped/stored to an internal object --> FakestoreDTO
        // convert FakestoreProductsdDto object into productObject.

        //return convertFakeStoreProductDtoToProductDto(fakeStoreProductDto);
    }

    @Override
    public List<Product> getAllProducts() {

        FakeStoreProductDto[] fakeStoreProductDtos =
                restTemplate.getForObject("http://localhost:8080/products/", FakeStoreProductDto[].class);
    //because of type erasure property of java, we can't give --> List<FakeStoreProductDto>.class (will throw error)
     // erasure effects collection (list) only, array no issue

        List<Product> products = new ArrayList<>();
        for (FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos) {
            products.add(convertFakeStoreProductDtoToProductDto(fakeStoreProductDto));
        }

        return products;
    }
}
