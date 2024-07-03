package com.eventBooking.eventBooking.services;

import com.eventBooking.eventBooking.data.models.EventType;
import com.eventBooking.eventBooking.data.models.Ticket;
import com.eventBooking.eventBooking.data.repositories.EventRepository;
import com.eventBooking.eventBooking.dtos.Request.CreateAnEventRequest;
import com.eventBooking.eventBooking.dtos.Request.RegisterRequest;
import com.eventBooking.eventBooking.dtos.Response.CreateAnEventResponse;
import com.eventBooking.eventBooking.dtos.Response.RegisterResponse;
import com.eventBooking.eventBooking.exception.OrganizerDoesNotExistException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class EventServiceImplTest {
    @Autowired
    private OrganizerService organizerService;
    @Autowired
    private EventService eventService;
    @Autowired
    private EventRepository eventRepository;
    @Test
    void testThatOrganizerCanCreateAnEvent() {
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setUsername("my username");
        registerRequest.setEmail("myname@gmail.com");
        registerRequest.setPassword("my password");
        RegisterResponse organizer = organizerService.registerOrganizer(registerRequest);
        assertNotNull(organizer.getId());
        CreateAnEventRequest createAnEventRequest = new CreateAnEventRequest();
        createAnEventRequest.setId(organizer.getId());
        createAnEventRequest.setTypeOfEvent(EventType.BIRTHDAY);
        createAnEventRequest.setAddress("Abuja");
        createAnEventRequest.setNumberOfTickets(50);
        createAnEventRequest.setNumberOfGuest(50);
        CreateAnEventResponse createEventResponse = eventService.createEvent(createAnEventRequest);
        assertNotNull(createEventResponse);
        assertTrue(createEventResponse.getMessage().contains("success"));
        assertEquals(1, eventRepository.count());
    }

    @Test
    public void throwsExceptionWhenEventIsCreatedWithoutAnOrganizer(){
        CreateAnEventRequest createAnEventRequest = new CreateAnEventRequest();
        createAnEventRequest.setId(1L);
        createAnEventRequest.setTypeOfEvent(EventType.BIRTHDAY);
        createAnEventRequest.setAddress("Abuja");
        createAnEventRequest.setNumberOfTickets(50);
        createAnEventRequest.setNumberOfGuest(50);
        assertThrows(OrganizerDoesNotExistException.class, () -> eventService.createEvent(createAnEventRequest));
    }
}