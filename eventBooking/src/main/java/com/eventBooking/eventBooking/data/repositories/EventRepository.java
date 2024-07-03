package com.eventBooking.eventBooking.data.repositories;

import com.eventBooking.eventBooking.data.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
