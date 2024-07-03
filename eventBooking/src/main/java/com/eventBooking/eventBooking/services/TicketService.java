package com.eventBooking.eventBooking.services;

import com.eventBooking.eventBooking.dtos.Request.AddTicketToEventRequest;
import com.eventBooking.eventBooking.dtos.Response.AddTicketToEventResponse;

public interface TicketService {
    AddTicketToEventResponse addTicketToEvent(AddTicketToEventRequest addTicketToEventRequest);
}
