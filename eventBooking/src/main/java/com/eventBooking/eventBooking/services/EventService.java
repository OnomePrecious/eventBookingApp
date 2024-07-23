package com.eventBooking.eventBooking.services;

import com.eventBooking.eventBooking.dtos.Request.CreateAnEventRequest;
import com.eventBooking.eventBooking.dtos.Request.ReserveTicketRequest;
import com.eventBooking.eventBooking.dtos.Response.CreateAnEventResponse;
import com.eventBooking.eventBooking.dtos.Response.ReserveTicketResponse;

public interface EventService {
    CreateAnEventResponse createEvent (CreateAnEventRequest createEventRequest);
    ReserveTicketResponse reserveTicket(ReserveTicketRequest reserveTicket);
}
