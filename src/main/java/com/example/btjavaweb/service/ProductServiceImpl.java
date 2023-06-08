package com.example.btjavaweb.service;

import com.example.btjavaweb.entity.Category;
import com.example.btjavaweb.entity.Products;
import com.example.btjavaweb.repository.CategoryRepository;
import com.example.btjavaweb.repository.ProductsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductsService{
    private final ProductsRepository productsRepo;
    private final CategoryRepository categoryRepo;
    @Override
    public Page<Products> getAllProduct(int page, int size, String productName) {
        Pageable pageable= PageRequest.of(page, size);
        return productsRepo.findByProductNameContainingIgnoreCase(productName,pageable);
    }

    @Override
    public Page<Products> getProductsByCategory(long categoryId, int page, int size) {
        Pageable pageable=PageRequest.of(page,size);
        if(categoryRepo.existsById(categoryId)){
            Category category=categoryRepo.findById(categoryId).orElseThrow();
            return productsRepo.findByCategory(category,pageable);
        }
        return null;
    }

    @Override
    public Products createProduct(Products product) {
        return productsRepo.save(product);
    }

    @Override
    public Products getProductById(Long productId) {
        if(productsRepo.existsById(productId)){
            return productsRepo.findById(productId).orElseThrow();
        }
        return null;
    }

    @Override
    public Products editProduct(Products products) {
        if(productsRepo.existsById(products.getProductId())){
            return productsRepo.save(products);
        }
        return null;
    }

    @Override
    public Boolean deleteProduct(Long productId) {
        if(productsRepo.existsById(productId)){
           productsRepo.deleteById(productId);
           return true;
        }
        return false;
    }
}
