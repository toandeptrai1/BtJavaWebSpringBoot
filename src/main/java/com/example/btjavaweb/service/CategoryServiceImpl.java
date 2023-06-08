package com.example.btjavaweb.service;

import com.example.btjavaweb.entity.Category;
import com.example.btjavaweb.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService{
    private final CategoryRepository categoryRepo;
    @Override
    public List<Category> getCategories() {
        return categoryRepo.findAll();
    }
}
