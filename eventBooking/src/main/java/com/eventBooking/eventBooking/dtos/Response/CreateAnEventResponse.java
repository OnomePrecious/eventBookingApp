package com.eventBooking.eventBooking.dtos.Response;

import com.eventBooking.eventBooking.data.models.EventType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateAnEventResponse {
    private Long id;
    private String message;
    private EventType eventType;
}
