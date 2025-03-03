package com.example.productservicesfeb2025.services;

import com.example.productservicesfeb2025.dtos.FakeStoreProductDto;
import com.example.productservicesfeb2025.exception.ProductNotFoundException;
import com.example.productservicesfeb2025.models.Category;
import com.example.productservicesfeb2025.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("fakeStoreProductService")

public class FakeStoreProductService implements ProductService{
    //This service implementation uses Fakestore to fetch products from FakeStore

    private RestTemplate restTemplate;
    public FakeStoreProductService (RestTemplate restTemplate) { //Constructor
        //RestTemplate restTemplate is already present in the ioc container/application context
        // that object will get injected into this object reference
        this.restTemplate = restTemplate;
    }
    private Product convertFakeStoreProductDtoToProduct(FakeStoreProductDto fakeStoreProductDto) {
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
        category.setName(fakeStoreProductDto.getCategory());
        product.setCategory(category);

        return product;

    }

    @Override
    public Product getProductById(Long productId) throws ProductNotFoundException {
        //Make an API call to FakeStore and get the product with the given id
        //http://localhost:8080/products/10

        //throw new RuntimeException("Something went wrong");


        FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject("https://fakestoreapi.com/products/" + productId,
                FakeStoreProductDto.class);
        // output getting from this url needs to be mapped/stored to an internal object --> FakestoreDTO
        // convert FakestoreProductsdDto object into productObject.

        if(fakeStoreProductDto == null) {
            throw new ProductNotFoundException("ProductId with id: " + productId + " doesn't exist.");
        }

        return convertFakeStoreProductDtoToProduct(fakeStoreProductDto);
    }

    @Override
    public List<Product> getAllProducts() {

        FakeStoreProductDto[] fakeStoreProductDtos =
                restTemplate.getForObject("https://fakestoreapi.com/products/", FakeStoreProductDto[].class);
    //because of type erasure property of java, we can't give --> List<FakeStoreProductDto>.class (will throw error)
     // erasure effects collection (list) only, array no issue

        List<Product> products = new ArrayList<>();
        for (FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos) {
            products.add(convertFakeStoreProductDtoToProduct(fakeStoreProductDto));
        }

        return products;
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public Product replaceProduct(Long id, Product product) {
        return null;
    }

    @Override
    public void deleteProduct(Long id) {

    }
}
