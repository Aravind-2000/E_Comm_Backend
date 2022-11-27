package com.example.ecomm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
