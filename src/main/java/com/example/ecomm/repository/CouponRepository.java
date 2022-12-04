package com.example.ecomm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ecomm.entity.Coupon;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CouponRepository extends JpaRepository<Coupon, Integer> {

    @Query(value = "select coupon_discount from coupon where coupon_code = :couponCode ", nativeQuery = true)
    int getCouponDiscount(@Param("couponCode") String couponCode);

}
