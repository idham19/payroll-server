package com.example.payroll_server.controller;

import com.example.payroll_server.model.Event;
import com.example.payroll_server.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/events")
public class EventController {
    @Autowired
    EventService eventService;

    @GetMapping
    public List<Event> getAllEvents() {
        return eventService.findAllEvents();
    }

    @GetMapping("/{id}")
    public Optional<Event> getEventById(Long id) {
        return eventService.findEventById(id);
    }

    @PutMapping("/{id}")
    public Event updateEvent(@PathVariable Long id, @RequestBody Event eventDetails) {
        return eventService.updateEvent(id, eventDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteEventById(@PathVariable Long id) {
        eventService.deleteEventById(id);
    }
}
