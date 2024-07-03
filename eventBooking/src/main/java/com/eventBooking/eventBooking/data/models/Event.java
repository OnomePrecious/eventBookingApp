package com.eventBooking.eventBooking.data.models;

import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter

public class Event {
    private Long id;
    private EventType typeOfEvent;
    private TicketType typeOfTicket;
    @OneToMany
    private List<Ticket> tickets= new ArrayList<>();
}
