package com.example.ecomm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ecomm.entity.Event;

public interface EventRepository extends JpaRepository<Event, Integer> {
    
}
