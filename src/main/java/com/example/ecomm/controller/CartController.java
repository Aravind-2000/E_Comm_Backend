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

import com.example.ecomm.entity.Cart;
import com.example.ecomm.repository.CartRepository;

@RestController
@RequestMapping("/cart")
@CrossOrigin
public class CartController {

    @Autowired
    private CartRepository cartRepository;

    @GetMapping("/getbyuser/{userid}")
    public ResponseEntity<?> getByUser(@PathVariable int userid) {
        Cart cart = cartRepository.getByUserId(userid);
        if (cart == null) {
            return ResponseEntity.ok("NULL");
        } else {
            return ResponseEntity.ok(cart);
        }
    }

    @GetMapping("/getcartid/{userid}")
    public int getCartId(@PathVariable int userid) {
        return cartRepository.getCartId(userid);
    }

    @PostMapping("/add")
    public String addCart(@RequestBody Cart cart) {
        cartRepository.save(cart);
        return "Cart Added";
    }

}
