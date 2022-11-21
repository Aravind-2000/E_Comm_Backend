package com.example.ecomm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.ecomm.entity.User;


public interface UserRepository extends JpaRepository<User, Integer> {



    @Query(value = "select * from user where user_email = :email and password = :pass", nativeQuery = true)
    public User login(@Param("email") String email, @Param("pass") String pass);

    public Boolean existsByUserEmail(String userEmail);


}
