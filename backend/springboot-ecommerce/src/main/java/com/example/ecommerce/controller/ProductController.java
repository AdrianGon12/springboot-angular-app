package com.example.ecommerce.controller;

import com.example.ecommerce.model.Product;
import com.example.ecommerce.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id) {
        Product product = productService.getProductById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<Page<Product>> getProductsByCategoryId(@PathVariable("id") Long id, @RequestParam int page, @RequestParam int size) {
        PageRequest pageable = PageRequest.of(page, size);
        Page<Product> products = productService.getProductsByCategoryId(id, pageable);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<Page<Product>> getProductsByName(@PathVariable("name") String name, @RequestParam int page, @RequestParam int size) {
        PageRequest pageable = PageRequest.of(page, size);
        Page<Product> products = productService.getProductsByName(name, pageable);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
