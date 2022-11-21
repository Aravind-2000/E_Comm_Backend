package com.example.ecomm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ecomm.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer> {

}
