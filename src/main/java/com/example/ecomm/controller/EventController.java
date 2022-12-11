package com.example.ecomm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.ecomm.entity.Coupon;
import com.example.ecomm.entity.Event;
import com.example.ecomm.repository.CouponRepository;
import com.example.ecomm.repository.EventRepository;

@RestController
@RequestMapping("/event")
@CrossOrigin
public class EventController {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private CouponRepository couponRepository;

    @GetMapping("/getall")
    public ResponseEntity<?> getAllEvents() {
        return ResponseEntity.ok(eventRepository.findAll());
    }

    @PostMapping("/add")
    public ResponseEntity<?> addEvent(@RequestBody Event event) {
        eventRepository.save(event);
        return ResponseEntity.ok("Event Added");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEvent(@PathVariable int id) {
        List<Coupon> coupons = couponRepository.findAll();
        for (Coupon coupon : coupons) {
            if (coupon.getEventId() == id) {
                return ResponseEntity.badRequest().body("You cannot delete this event, it is associated with a coupon");
            }
        }
        eventRepository.deleteById(id);
        return ResponseEntity.ok("Event deleted");
    }

    @PatchMapping("/edit/{id}")
    public ResponseEntity<?> editEvent(@PathVariable int id, @RequestBody Event newEvent) {

        Event oldEvent = eventRepository.getReferenceById(id);

        if (newEvent.getEventName() != null) {
            oldEvent.setEventName(newEvent.getEventName());
        }

        if (newEvent.getEventStartDate() != null) {
            oldEvent.setEventStartDate(newEvent.getEventStartDate());
        }

        if (newEvent.getEventEndDate() != null) {
            oldEvent.setEventEndDate(newEvent.getEventEndDate());
        }

        eventRepository.save(oldEvent);
        return ResponseEntity.ok("Event modified successfully");
    }
}
