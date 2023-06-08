package com.example.btjavaweb.controller;

import com.example.btjavaweb.dto.ApiResponse;
import com.example.btjavaweb.dto.ProductsRequest;
import com.example.btjavaweb.entity.Products;
import com.example.btjavaweb.service.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static java.time.LocalTime.now;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {
    private final ProductServiceImpl productService;
    @PostMapping
    public ResponseEntity<ApiResponse> getAllProduct(@RequestBody ProductsRequest productRequest){

        ApiResponse apiResponse= ApiResponse.builder()
                .message("successful!")
                .status(HttpStatus.OK)
                .timeStamp(now().toString())
                .data(Map.of("page",productService.getAllProduct(productRequest.getPage(), productRequest.getSize(), productRequest.getProductName())))
                .build();

        return ResponseEntity.ok().body(apiResponse);
    }
    @PostMapping("/getByCategory")
    public ResponseEntity<ApiResponse> getProductByCategory(@RequestBody ProductsRequest productRequest){
        ApiResponse apiResponse= ApiResponse.builder()
                .message("successful!")
                .status(HttpStatus.OK)
                .timeStamp(now().toString())
                .data(Map.of("page",productService.getProductsByCategory(productRequest.getCategoryId(), productRequest.getPage(), productRequest.getSize())))
                .build();
        return ResponseEntity.ok().body(apiResponse);
    }
    @GetMapping("/{productId}")
    public ResponseEntity<Products> getProductId(@PathVariable Long productId){

        return ResponseEntity.ok().body(productService.getProductById(productId));
    }
    @PostMapping("/add")
    public ResponseEntity<Products> createProduct(@RequestBody Products Product){

        return ResponseEntity.ok().body(productService.createProduct(Product));
    }
    @PostMapping("/edit")
    public ResponseEntity<Products> editProduct(@RequestBody Products Product){

        return ResponseEntity.ok().body(productService.editProduct(Product));
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteProduct(@PathVariable Long id){

        return ResponseEntity.ok().body(productService.deleteProduct(id));
    }




}
