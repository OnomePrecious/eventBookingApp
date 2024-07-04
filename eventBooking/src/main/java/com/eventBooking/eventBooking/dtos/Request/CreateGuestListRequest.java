package com.eventBooking.eventBooking.dtos.Request;

import com.eventBooking.eventBooking.data.models.Guest;
import com.eventBooking.eventBooking.data.models.TicketType;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CreateGuestListRequest {
    private Long eventId;
    private List<Guest> guestList;
    private String GuestName;
    private TicketType ticketType;

}
