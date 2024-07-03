package com.eventBooking.eventBooking.data.repositories;

import com.eventBooking.eventBooking.data.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
