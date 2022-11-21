package com.example.ecomm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ecomm.entity.Coupon;

public interface CouponRepository extends JpaRepository<Coupon, Integer> {

}
