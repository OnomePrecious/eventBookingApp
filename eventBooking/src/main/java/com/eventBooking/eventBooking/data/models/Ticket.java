package com.eventBooking.eventBooking.data.models;

import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Ticket {
    private Long ticketId;
    private Discount discountPrice;
    private TicketType ticketType;
    @ManyToOne
    private Event event;

}
