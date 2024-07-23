package com.eventBooking.eventBooking.controllers;

import com.eventBooking.eventBooking.dtos.Request.RegisterRequest;
import com.eventBooking.eventBooking.services.EventService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ap1/v1/event")
@AllArgsConstructor
public class BookingController {

    private final EventService eventService;
    @PostMapping
    public ResponseEntity<?> registerOrganizer(@RequestBody RegisterRequest registerRequest){
        try{

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
