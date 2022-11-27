package com.example.ecomm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ecomm.entity.OrderDetails;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Integer> {

    public List<OrderDetails> getByUserId(int userId);

}
