package com.example.ecomm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.ecomm.entity.Event;
import com.example.ecomm.repository.EventRepository;

@RestController
@RequestMapping("/event")
@CrossOrigin
public class EventController {

    @Autowired
    private EventRepository eventRepository;

    @GetMapping("/getall")
    public ResponseEntity<?> getAllEvents() {
        return ResponseEntity.ok(eventRepository.findAll());
    }

    @PostMapping("/add")
    public ResponseEntity<?> addEvent(@RequestBody Event event) {
        eventRepository.save(event);
        return ResponseEntity.ok("Event Added");
    }

    @PatchMapping("/edit/{id}")
    public ResponseEntity<?> editEvent(@PathVariable int id, @RequestBody Event newEvent){

        Event oldEvent = eventRepository.getReferenceById(id);

        if(newEvent.getEventName() != null){
            oldEvent.setEventName(newEvent.getEventName());
        }

        if(newEvent.getEventStartDate() != null){
            oldEvent.setEventStartDate(newEvent.getEventStartDate());
        }

        if(newEvent.getEventEndDate() != null){
            oldEvent.setEventEndDate(newEvent.getEventEndDate());
        }

        eventRepository.save(oldEvent);
        return ResponseEntity.ok("Event modified successfully");
    }
}
