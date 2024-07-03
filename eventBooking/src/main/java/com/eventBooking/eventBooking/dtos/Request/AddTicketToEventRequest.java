package com.eventBooking.eventBooking.dtos.Request;
import com.eventBooking.eventBooking.data.models.Event;
import com.eventBooking.eventBooking.data.models.EventType;
import com.eventBooking.eventBooking.data.models.TicketType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddTicketToEventRequest {
    private Long id;
    private Double price;
    private int availableSeats;
    private EventType typeOfEvent;
    private TicketType ticketType;

}
