package com.eventBooking.eventBooking.services;

import com.eventBooking.eventBooking.dtos.Request.CreateAnEventRequest;
import com.eventBooking.eventBooking.dtos.Response.CreateAnEventResponse;

public interface EventService {
    CreateAnEventResponse createEvent (CreateAnEventRequest createEventRequest);
}
