package com.eventBooking.eventBooking.data.repositories;

import com.eventBooking.eventBooking.data.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {
  List<Event> findGuestsBy(Long eventId);
}
