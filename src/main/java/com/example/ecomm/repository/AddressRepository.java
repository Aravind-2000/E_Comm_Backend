package com.example.ecomm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.ecomm.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {


    @Query(value = "select * from address where userId = :userid", nativeQuery = true)
    public List<Address> getAddByUser(@Param("userid") int userid);

}
