package com.example.ecommerce.service;

import com.example.ecommerce.model.ProductCategory;
import com.example.ecommerce.repository.ProductCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCategoryService {

    private final ProductCategoryRepository productCategoryRepository;

    public ProductCategoryService(ProductCategoryRepository productCategoryRepository) {
        this.productCategoryRepository = productCategoryRepository;
    }

    public List<ProductCategory> getCategories() {
        return productCategoryRepository.findAll();
    }
}
