package com.eventBooking.eventBooking.exception;

public class NoTicketsAvailableException extends EventBookingException{
    public NoTicketsAvailableException(String message) {
        super(message);
    }
}
