package com.eventBooking.eventBooking.dtos.Request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ReserveTicketRequest {
    private Long ticketId;
    private Long guestId;
    private int availableTicket;
}
