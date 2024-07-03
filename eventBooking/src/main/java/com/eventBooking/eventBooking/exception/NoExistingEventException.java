package com.eventBooking.eventBooking.exception;

public class NoExistingEventException extends EventBookingException{
    public NoExistingEventException(String message) {
        super(message);
    }
}
