package com.example.payroll_server.controller;

import com.example.payroll_server.model.Event;
import com.example.payroll_server.service.EventService;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/events")
public class EventController {
    @Autowired
    EventService eventService;

    @PutMapping("/{id}")
    public Event updateEvent(@PathVariable Long id, @RequestBody Event eventDetails) {
        Event event = eventService.findEventById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Event not found"));
        event.setTitle(eventDetails.getTitle());
        event.setStart(eventDetails.getStart());
        event.setEnd(eventDetails.getEnd());
        event.setColor(eventDetails.getColor());
        return eventService.addEvent(event);
    }

}
