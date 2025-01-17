package com.eventBooking.eventBooking.controllers;

import com.eventBooking.eventBooking.dtos.Request.*;
import com.eventBooking.eventBooking.dtos.Response.ApiResponse;
import com.eventBooking.eventBooking.services.DiscountService;
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
    @Autowired
    private DiscountService discountService;

    @PostMapping("/register")
    public ResponseEntity<?> registerOrganizer(@RequestBody RegisterRequest registerRequest){
        try{
            var result = organizerService.registerOrganizer(registerRequest);
            return new ResponseEntity<>(new ApiResponse(true, result), CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), BAD_REQUEST);

        }
    }


    @PostMapping("/createEvent")
    public ResponseEntity<?> createAnEvent(@RequestBody CreateAnEventRequest createAnEventRequest){
        try{
            var result = eventService.createEvent(createAnEventRequest);
            return new ResponseEntity<>(new ApiResponse(true, result), CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), BAD_REQUEST);
        }
    }


    @PostMapping("/addTicket")
    public ResponseEntity<?> addTicketToEvent(@RequestBody AddTicketToEventRequest addTicketToEventRequest){
        try {
            var result = ticketService.addTicketToEvent(addTicketToEventRequest);
            return new ResponseEntity<>(new ApiResponse(true, result), CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), BAD_REQUEST);

        }
    }


    @PostMapping("/addDiscountToTicket")
    public ResponseEntity<?> createDiscountForTicket(@RequestBody CreateDiscountForTicketRequest discountRequest){
        try {
            var result = discountService.createDiscountForTicket(discountRequest);
            return new ResponseEntity<>(new ApiResponse(true, result), CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), BAD_REQUEST);
        }
        }


        @PostMapping("/createGuestList")
    public ResponseEntity<?> createGuestList(@RequestBody CreateGuestListRequest guestListRequest){
        try {
            var result = organizerService.createGuestList(guestListRequest);
            return new ResponseEntity<>(new ApiResponse(true, result), CREATED);
        } catch(Exception e){
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), BAD_REQUEST);
        }
        }

        @PostMapping("/bookTicket")
    public ResponseEntity<?> bookTicket(@RequestBody ReserveTicketRequest reservationRequest){
        try {
            var result = eventService.reserveTicket(reservationRequest);
            return new ResponseEntity<>(new ApiResponse(true, result), CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), BAD_REQUEST);

        }
        }
    }

