package com.eventBooking.eventBooking.data.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Event {
    private Long id;
    private EventType typeOfEvent;
}
