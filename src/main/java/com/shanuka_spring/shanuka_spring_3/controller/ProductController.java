package com.shanuka_spring.shanuka_spring_3.controller;

import com.shanuka_spring.shanuka_spring_3.dto.ProductDto;
import com.shanuka_spring.shanuka_spring_3.entity.Product;
import com.shanuka_spring.shanuka_spring_3.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {


    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public Product createProduct(@RequestBody ProductDto productDto) {
        return productService.createProduct(productDto);
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN') or hasRole('CLIENT')")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }
}
