package com.example.btjavaweb.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductsRequest {
    private String productName;
    private Long categoryId;
    private Integer page;
    private Integer size;

}
