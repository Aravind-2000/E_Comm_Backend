package com.example.ecomm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ecomm.entity.PaymentDetails;

public interface PaymentDetailsRepository extends JpaRepository<PaymentDetails, Integer> {
    


}
