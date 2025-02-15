package com.shanuka_spring.shanuka_spring_3.repository;

import com.shanuka_spring.shanuka_spring_3.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
}
