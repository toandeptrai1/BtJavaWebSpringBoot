package com.example.btjavaweb.repository;

import com.example.btjavaweb.entity.Category;
import com.example.btjavaweb.entity.Products;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepository extends JpaRepository<Products,Long> {
    Page<Products> findByProductNameContainingIgnoreCase(String productName, Pageable pageable);
    Page<Products> findByCategory(Category category, Pageable pageable);

}
