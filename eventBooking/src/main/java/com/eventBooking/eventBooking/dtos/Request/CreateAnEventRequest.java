package com.eventBooking.eventBooking.dtos.Request;

import com.eventBooking.eventBooking.data.models.EventType;
import com.eventBooking.eventBooking.data.models.Guest;
import com.eventBooking.eventBooking.data.models.Ticket;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CreateAnEventRequest {
    private Long id;
    private String address;
    private EventType typeOfEvent;
    private int numberOfGuest;
    private int numberOfTickets;

}
