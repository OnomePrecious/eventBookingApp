package com.eventBooking.eventBooking.data.repositories;

import com.eventBooking.eventBooking.data.models.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepository extends JpaRepository<Guest, Long> {
}
