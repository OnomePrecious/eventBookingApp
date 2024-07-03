package com.eventBooking.eventBooking.services;

import com.eventBooking.eventBooking.data.models.EventType;
import com.eventBooking.eventBooking.data.models.TicketType;
import com.eventBooking.eventBooking.data.repositories.TicketRepository;
import com.eventBooking.eventBooking.dtos.Request.AddTicketToEventRequest;
import com.eventBooking.eventBooking.dtos.Request.CreateAnEventRequest;
import com.eventBooking.eventBooking.dtos.Request.RegisterRequest;
import com.eventBooking.eventBooking.dtos.Response.AddTicketToEventResponse;
import com.eventBooking.eventBooking.dtos.Response.CreateAnEventResponse;
import com.eventBooking.eventBooking.dtos.Response.RegisterResponse;
import com.eventBooking.eventBooking.exception.NoExistingEventException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class TicketServiceImplTest {
@Autowired
private TicketService ticketService;
@Autowired
private OrganizerService organizerService;
@Autowired
private EventService eventService;
@Autowired
private TicketRepository ticketRepository;
    @Test
    void testThatOrganizerCanAddTicketToEvent() {
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setUsername("my username");
        registerRequest.setEmail("myname@gmail.com");
        registerRequest.setPassword("my password");
        RegisterResponse organizer = organizerService.registerOrganizer(registerRequest);

        CreateAnEventRequest createAnEventRequest = new CreateAnEventRequest();
        createAnEventRequest.setId(organizer.getId());
        createAnEventRequest.setTypeOfEvent(EventType.BIRTHDAY);
        createAnEventRequest.setAddress("Abuja");
        createAnEventRequest.setNumberOfTickets(50);
        createAnEventRequest.setNumberOfGuest(50);
        eventService.createEvent(createAnEventRequest);

        AddTicketToEventRequest addTicketToEventRequest = new AddTicketToEventRequest();
        addTicketToEventRequest.setTicketType(TicketType.REGULAR);
        addTicketToEventRequest.setId(createAnEventRequest.getId());
        addTicketToEventRequest.setPrice(4000.0);
        addTicketToEventRequest.setAvailableSeats(40);
        addTicketToEventRequest.setTypeOfEvent(EventType.CONCERT);
        AddTicketToEventResponse addTicketToEventResponse = ticketService.addTicketToEvent(addTicketToEventRequest);
        assertNotNull(addTicketToEventResponse);
        assertEquals(40, addTicketToEventRequest.getAvailableSeats());
        assertTrue(addTicketToEventResponse.getMessage().contains("success"));
        assertEquals(1, ticketRepository.count());

    }

    @Test
    public void throwsExceptionWhenOrganizerTriesToAddTicketWithoutCreatingAnEventFirst(){
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setUsername("my username");
        registerRequest.setEmail("myname@gmail.com");
        registerRequest.setPassword("my password");
        RegisterResponse organizer = organizerService.registerOrganizer(registerRequest);

        AddTicketToEventRequest addTicketToEventRequest = new AddTicketToEventRequest();
        addTicketToEventRequest.setTicketType(TicketType.VIP);
        addTicketToEventRequest.setId(organizer.getId());
        addTicketToEventRequest.setPrice(6000.0);
        addTicketToEventRequest.setAvailableSeats(20);
        addTicketToEventRequest.setTypeOfEvent(EventType.CONCERT);
        assertThrows(NoExistingEventException.class, () -> ticketService.addTicketToEvent(addTicketToEventRequest));
    }
}