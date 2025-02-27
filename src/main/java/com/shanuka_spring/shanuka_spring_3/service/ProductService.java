package com.shanuka_spring.shanuka_spring_3.service;

import com.shanuka_spring.shanuka_spring_3.dto.ProductDto;
import com.shanuka_spring.shanuka_spring_3.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    List<Product> getAllProducts();
    Product createProduct(ProductDto productDto);
}
