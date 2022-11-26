package com.example.ecomm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ecomm.entity.OrderDetails;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Integer> {

    public OrderDetails getByUserId(int userId);

}
