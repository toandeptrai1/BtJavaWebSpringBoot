package com.example.btjavaweb.entity;



import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    private String productName;
    private Double price;
    private String desc;
    private String brand;
    private String image;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoryId",referencedColumnName = "categoryId",nullable = false)
    private Category category;

}
