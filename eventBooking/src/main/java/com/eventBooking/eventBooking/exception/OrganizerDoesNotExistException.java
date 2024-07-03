package com.eventBooking.eventBooking.exception;

public class OrganizerDoesNotExistException extends NoExistingEventException{
    public OrganizerDoesNotExistException(String message) {
        super(message);
    }
}
