package com.example.ecomm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecomm.entity.OrderDetails;
import com.example.ecomm.repository.OrderDetailsRepository;

@RestController
@RequestMapping("/orders")
@CrossOrigin(origins = "null", allowedHeaders = "*")
public class OrderController {

    @Autowired
    private OrderDetailsRepository ordersRepository;

    @GetMapping("/getorderbyuser/{userid}")
    public ResponseEntity<?> getByUser(@PathVariable int userid) {
        OrderDetails orderDetails = ordersRepository.getByUserId(userid);
        if (orderDetails != null) {
            return ResponseEntity.ok(orderDetails);
        } else {
            return ResponseEntity.ok("Empty");
        }
    }

    @PostMapping("/placeorder")
    public ResponseEntity<?> placeOrder(@RequestBody OrderDetails orderDetails) {
        ordersRepository.save(orderDetails);
        return ResponseEntity.ok("Order Placed");
    }
}
