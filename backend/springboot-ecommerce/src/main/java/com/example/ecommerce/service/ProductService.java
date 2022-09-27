package com.example.ecommerce.service;

import com.example.ecommerce.model.Product;
import com.example.ecommerce.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findProductById(id).orElseThrow();
    }

    public Page<Product> getProductsByCategoryId(Long id, Pageable pageable) {
        return productRepository.findByCategoryId(id, pageable);
    }

    public Page<Product> getProductsByName(String name, Pageable pageable) {
        return productRepository.findByNameContaining(name, pageable);
    }
}
