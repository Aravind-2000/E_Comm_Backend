package com.example.ecomm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.ecomm.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query(value = "select * from product where product_id = :productId", nativeQuery = true)
    public Product geProduct(@Param("productId") int productId);

    @Query(value = "select * from product where is_available = 1", nativeQuery = true)
    public List<Product> availableProducts();
}
