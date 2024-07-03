package com.eventBooking.eventBooking.dtos.Request;

import com.eventBooking.eventBooking.data.models.EventType;
import com.eventBooking.eventBooking.data.models.Guest;
import com.eventBooking.eventBooking.data.models.Ticket;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateAnEventRequest {
    private Long id;
    private EventType typeOfEvent;
    private Guest numberOfGuest;
    private Ticket numberOfTicket;

}
