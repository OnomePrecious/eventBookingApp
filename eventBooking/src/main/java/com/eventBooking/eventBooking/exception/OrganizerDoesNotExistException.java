package com.eventBooking.eventBooking.exception;

public class OrganizerDoesNotExistException extends RuntimeException{
    public OrganizerDoesNotExistException(String message) {
        super(message);
    }
}
