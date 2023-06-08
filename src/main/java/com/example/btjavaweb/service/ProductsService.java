package com.example.btjavaweb.service;

import com.example.btjavaweb.entity.Products;
import org.springframework.data.domain.Page;

public interface ProductsService {
    Page<Products> getAllProduct(int page, int size, String productName);
    Page<Products> getProductsByCategory(long categoryId, int page, int size);
    Products createProduct(Products product);
    Products getProductById(Long productId);

    Products editProduct(Products products);
    Boolean deleteProduct(Long productId);

}
