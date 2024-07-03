package com.eventBooking.eventBooking.services;

import com.eventBooking.eventBooking.dtos.Request.AddTicketToEventRequest;
import com.eventBooking.eventBooking.dtos.Request.CreateAnEventRequest;
import com.eventBooking.eventBooking.dtos.Request.RegisterRequest;
import com.eventBooking.eventBooking.dtos.Response.AddTicketToEventResponse;
import com.eventBooking.eventBooking.dtos.Response.CreateAnEventResponse;
import com.eventBooking.eventBooking.dtos.Response.RegisterResponse;

public interface OrganizerService {
    RegisterResponse registerOrganizer (RegisterRequest registerRequest);
    AddTicketToEventResponse addTicketToEvent (AddTicketToEventRequest addTicketToEventRequest);
}
