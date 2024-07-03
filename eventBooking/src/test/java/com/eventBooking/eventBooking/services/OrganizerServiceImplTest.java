package com.eventBooking.eventBooking.services;

import com.eventBooking.eventBooking.data.repositories.OrganizerRepository;
import com.eventBooking.eventBooking.dtos.Request.CreateAnEventRequest;
import com.eventBooking.eventBooking.dtos.Request.RegisterRequest;
import com.eventBooking.eventBooking.dtos.Response.RegisterResponse;
import com.eventBooking.eventBooking.exception.InvalidDetailsException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class OrganizerServiceImplTest {
    @Autowired
    private OrganizerService organizerService;
    @Autowired
    private OrganizerRepository organizerRepository;

    @Test
    void testThatAnOrganizerCanRegister() {
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setUsername("my username");
        registerRequest.setEmail("myname@gmail.com");
        registerRequest.setPassword("my password");
        RegisterResponse registerResponse = organizerService.registerOrganizer(registerRequest);
        assertNotNull(registerResponse);
        assertTrue(registerResponse.getMessage().contains("success"));
        assertEquals("my username", registerRequest.getUsername());
        assertEquals(1, organizerRepository.count());
    }




    }

