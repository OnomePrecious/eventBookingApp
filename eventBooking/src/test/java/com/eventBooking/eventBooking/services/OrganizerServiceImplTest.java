package com.eventBooking.eventBooking.services;

import com.eventBooking.eventBooking.dtos.Request.RegisterRequest;
import com.eventBooking.eventBooking.dtos.Response.RegisterResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class OrganizerServiceImplTest {
    @Autowired
    private OrganizerService organizerService;

    @Test
    void testThatAnOrganizerCanRegister() {
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setUsername("my username");
        registerRequest.setEmail("myname@gmail.com");
        registerRequest.setPassword("my password");
        RegisterResponse registerResponse = organizerService.registerOrganizer(registerRequest);
        assertNotNull(registerResponse);
        assertTrue(registerResponse.getMessage().contains("success"));
    }

    @Test
    void createEvent() {
    }

    @Test
    void addTicketToEvent() {
    }
}