package com.example.ecomm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.ecomm.entity.Coupon;
import com.example.ecomm.entity.Event;
import com.example.ecomm.repository.CouponRepository;
import com.example.ecomm.repository.EventRepository;

@RestController
@RequestMapping("/coupon")
@CrossOrigin
public class CouponController {

    @Autowired
    private CouponRepository couponRepository;

    @Autowired
    private EventRepository eventRepository;

    @GetMapping("/getall")
    public ResponseEntity<?> getall() {
        return ResponseEntity.ok(couponRepository.findAll());
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Coupon coupon) {
        if (coupon.getEventId() != null) {
            Event event = eventRepository.getReferenceById(coupon.getEventId());
            coupon.setExpiryDate(event.getEventEndDate());
        }
        couponRepository.save(coupon);
        return ResponseEntity.ok("Coupon Added");
    }

    @GetMapping("/getcoupondiscount/{couponCode}")
    public int getDiscount(@PathVariable String couponCode){
        return couponRepository.getCouponDiscount(couponCode);
    }


    @PatchMapping("/edit/{id}")
    public ResponseEntity<?> editCoupon(@PathVariable int id, Coupon newCoupon){

        Coupon oldCoupon = couponRepository.getReferenceById(id);

        if(newCoupon.getCouponCode() != null){
            oldCoupon.setCouponCode(newCoupon.getCouponCode());
        }

        if(newCoupon.getCouponDiscount() != null){
            oldCoupon.setCouponDiscount(newCoupon.getCouponDiscount());
        }

        if(newCoupon.getExpiryDate() != null){
            oldCoupon.setExpiryDate(newCoupon.getExpiryDate());
        }

        if(newCoupon.getEventId() != null){
            oldCoupon.setEventId(newCoupon.getEventId());
        }

        couponRepository.save(oldCoupon);
        return ResponseEntity.ok("Coupon Modified Successfully");

    }

}
