package com.example.btjavaweb.controller;

import com.example.btjavaweb.entity.Category;
import com.example.btjavaweb.service.CategoryServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/category")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class CategoryController {

    private final CategoryServiceImpl categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> getCategories(){
        return  ResponseEntity.ok().body(categoryService.getCategories());
    }

}
