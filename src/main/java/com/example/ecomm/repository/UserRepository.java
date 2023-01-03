package com.example.ecomm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.ecomm.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "select * from user where user_email = :email and password = :pass", nativeQuery = true)
    public User login(@Param("email") String email, @Param("pass") String pass);

    /*
     * @Query(value="select * from user where user_email = :email and role_flag = 0"
     * , nativeQuery = true)
     * public User existsByUserEmailCustomer(@Param("email")String email);
     * 
     * @Query(value="select * from user where user_email = :email and role_flag = 1"
     * , nativeQuery = true)
     * public User existsByUserEmailAdmin(@Param("email")String email);
     */

    public Boolean existsByUserEmailAndRoleFlag(String userEmail, Integer roleFlag);

}
