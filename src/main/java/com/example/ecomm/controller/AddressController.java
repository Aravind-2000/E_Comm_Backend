package com.example.ecomm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.ecomm.service.AddressService;

@RestController
@RequestMapping("/address")
@CrossOrigin(origins ="null", allowedHeaders = "*")
public class AddressController {


    @Autowired
    private AddressService addressService;



    @GetMapping("/getbyuser/{userId}")
    public ResponseEntity<?> getAddressByUserController(@PathVariable int userId){
        return ResponseEntity.ok(addressService.getAddressByUser(userId));
    }
    
}
