package com.example.ecomm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ecomm.entity.PaymentType;

public interface PaymentTypeRepository extends JpaRepository<PaymentType, Integer> {

}
