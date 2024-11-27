package com.example.payroll_server.service;

import com.example.payroll_server.model.Event;
import com.example.payroll_server.repositories.EventRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {
    @Autowired
    EventRepository eventRepository;

    public Event addEvent(Event event) {
        return eventRepository.save(event);
    }
    public Event updateEvent(Long id, Event eventDetails) {
        Event event = eventRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Event not found"));
        event.setTitle(eventDetails.getTitle());
        event.setComment(eventDetails.getComment());
        event.setEnd(eventDetails.getEnd());
        event.setStart(eventDetails.getStart());
        event.setColor(eventDetails.getColor());
        return eventRepository.save(event);
    }
    public List<Event> findAllEvents() {
        return eventRepository.findAll();
    }

    public Optional<Event> findEventById(Long id) {
        return eventRepository.findById(id);
    }

    public void deleteEventById(Long id) {
        eventRepository.deleteById(id);
    }
}
