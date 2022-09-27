package com.example.ecommerce.repository;

import com.example.ecommerce.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findProductById(Long id);

    Page<Product> findByCategoryId(Long id, Pageable pageable);

    Page<Product> findByNameContaining(String name, Pageable pageable);
}
