package com.example.ecomm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.ecomm.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer> {

    @Query(value = "select * from cart where user_id = :userId", nativeQuery = true)
    public Cart getByUserId(@Param("userId") int userId);

    @Query(value = "select id from cart where user_id = :userId", nativeQuery = true)
    public int getCartId(@Param("userId") int userId);

}
