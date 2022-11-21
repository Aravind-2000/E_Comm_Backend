package com.example.ecomm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ecomm.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
