package com.eventBooking.eventBooking.dtos.Request;

import com.eventBooking.eventBooking.data.models.TicketType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateGuestListRequest {
    private Long id;
    private String name;
    private TicketType ticketType;

}
