package com.example.payroll_server.repositories;

import com.example.payroll_server.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
