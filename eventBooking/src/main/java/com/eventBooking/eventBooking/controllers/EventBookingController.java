package com.eventBooking.eventBooking.controllers;

import com.eventBooking.eventBooking.dtos.Request.AddTicketToEventRequest;
import com.eventBooking.eventBooking.dtos.Request.CreateAnEventRequest;
import com.eventBooking.eventBooking.dtos.Request.RegisterRequest;
import com.eventBooking.eventBooking.dtos.Response.ApiResponse;
import com.eventBooking.eventBooking.services.EventService;
import com.eventBooking.eventBooking.services.OrganizerService;
import com.eventBooking.eventBooking.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("ap1/v1/event")
public class EventBookingController {
    @Autowired
    private EventService eventService;
    @Autowired
    private OrganizerService organizerService;
    @Autowired
    private TicketService ticketService;

    @PostMapping
    public ResponseEntity<?> registerOrganizer(@RequestBody RegisterRequest registerRequest){
        try{
            var result = organizerService.registerOrganizer(registerRequest);
            return new ResponseEntity<>(new ApiResponse(true, result), CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), BAD_REQUEST);

        }
    }
    @PostMapping
    public ResponseEntity<?> createAnEvent(@RequestBody CreateAnEventRequest createAnEventRequest){
        try{
            var result = eventService.createEvent(createAnEventRequest);
            return new ResponseEntity<>(new ApiResponse(true, result), CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), BAD_REQUEST);
        }
    }
    @PostMapping
    public ResponseEntity<?> addTicketToEvent(@RequestBody AddTicketToEventRequest addTicketToEventRequest){
        try {
            var result = ticketService.addTicketToEvent(addTicketToEventRequest);
            return new ResponseEntity<>(new ApiResponse(true, result), CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), BAD_REQUEST);

        }
    }
}
