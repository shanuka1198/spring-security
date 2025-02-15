package com.shanuka_spring.shanuka_spring_3.service.impl;

import com.shanuka_spring.shanuka_spring_3.dto.ProductDto;
import com.shanuka_spring.shanuka_spring_3.entity.Product;
import com.shanuka_spring.shanuka_spring_3.repository.ProductRepository;
import com.shanuka_spring.shanuka_spring_3.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {


    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product createProduct(ProductDto productDto) {
        Product product = new Product(
                productDto.getProductId(),
                productDto.getProductName(),
                productDto.getQty()
        );
        System.out.println(product);
        return productRepository.save(product);
    }
}
