package com.example.ecomm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecomm.entity.Address;
import com.example.ecomm.repository.AddressRepository;

@Service
public class AddressService {
    
    @Autowired
    private AddressRepository addressRepository;


    public List<Address> getAddressByUser(int userid) {
        return addressRepository.getAddByUser(userid);
    } 

}
