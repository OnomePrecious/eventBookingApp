package com.eventBooking.eventBooking.services;

import com.eventBooking.eventBooking.data.models.EventType;
import com.eventBooking.eventBooking.data.models.Ticket;
import com.eventBooking.eventBooking.data.models.TicketType;
import com.eventBooking.eventBooking.data.repositories.EventRepository;
import com.eventBooking.eventBooking.data.repositories.TicketRepository;
import com.eventBooking.eventBooking.dtos.Request.AddTicketToEventRequest;
import com.eventBooking.eventBooking.dtos.Request.CreateAnEventRequest;
import com.eventBooking.eventBooking.dtos.Request.RegisterRequest;
import com.eventBooking.eventBooking.dtos.Request.ReserveTicketRequest;
import com.eventBooking.eventBooking.dtos.Response.AddTicketToEventResponse;
import com.eventBooking.eventBooking.dtos.Response.CreateAnEventResponse;
import com.eventBooking.eventBooking.dtos.Response.RegisterResponse;
import com.eventBooking.eventBooking.dtos.Response.ReserveTicketResponse;
import com.eventBooking.eventBooking.exception.NoTicketsAvailableException;
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
    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private TicketService ticketService;
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

    @Test
    void reserveTicket() {
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
        eventService.createEvent(createAnEventRequest);

        AddTicketToEventRequest addTicketToEventRequest = new AddTicketToEventRequest();
        addTicketToEventRequest.setTicketType(TicketType.REGULAR);
        addTicketToEventRequest.setId(createAnEventRequest.getId());
        addTicketToEventRequest.setPrice(4000.0);
        addTicketToEventRequest.setAvailableSeats(createAnEventRequest.getNumberOfTickets());
        addTicketToEventRequest.setTypeOfEvent(EventType.CONCERT);
        AddTicketToEventResponse response = ticketService.addTicketToEvent(addTicketToEventRequest);

        ReserveTicketRequest reserveTicketRequest = new ReserveTicketRequest();
        reserveTicketRequest.setTicketId(response.getId());
        reserveTicketRequest.setAvailableTicket(createAnEventRequest.getNumberOfTickets());
        ReserveTicketResponse reserveTicketResponse = eventService.reserveTicket(reserveTicketRequest);
        assertNotNull(reserveTicketResponse);
    }
    @Test
    public void throwsTicketNotAvailableExceptionWhenThereIsNoTicketToReserve(){
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
        eventService.createEvent(createAnEventRequest);

        AddTicketToEventRequest addTicketToEventRequest = new AddTicketToEventRequest();
        addTicketToEventRequest.setTicketType(TicketType.REGULAR);
        addTicketToEventRequest.setId(createAnEventRequest.getId());
        addTicketToEventRequest.setPrice(4000.0);
        addTicketToEventRequest.setAvailableSeats(50);
        addTicketToEventRequest.setTypeOfEvent(EventType.CONCERT);
        ticketService.addTicketToEvent(addTicketToEventRequest);
        ReserveTicketRequest reserveTicketRequest = new ReserveTicketRequest();
        reserveTicketRequest.setTicketId(reserveTicketRequest.getTicketId());
        reserveTicketRequest.setAvailableTicket(createAnEventRequest.getNumberOfTickets()+1);
        assertThrows(NoTicketsAvailableException.class, () -> eventService.reserveTicket(reserveTicketRequest));

    }
}