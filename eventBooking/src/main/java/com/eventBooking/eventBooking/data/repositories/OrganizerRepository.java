package com.eventBooking.eventBooking.data.repositories;

import com.eventBooking.eventBooking.data.models.Organizer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizerRepository extends JpaRepository<Organizer, Long> {

}
