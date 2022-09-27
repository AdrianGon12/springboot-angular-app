package com.example.ecommerce.controller;

import com.example.ecommerce.model.ProductCategory;
import com.example.ecommerce.service.ProductCategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/categories")
public class ProductCategoryController {

    private final ProductCategoryService productCategoryService;

    public ProductCategoryController(ProductCategoryService productCategoryService) {
        this.productCategoryService = productCategoryService;
    }

    @GetMapping("")
    public ResponseEntity<List<ProductCategory>> getCategories() {
        List<ProductCategory> categories = productCategoryService.getCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }
}
