package com.eventBooking.eventBooking.services;

import com.eventBooking.eventBooking.data.models.EventType;
import com.eventBooking.eventBooking.data.models.TicketType;
import com.eventBooking.eventBooking.data.repositories.DiscountRepository;
import com.eventBooking.eventBooking.dtos.Request.AddTicketToEventRequest;
import com.eventBooking.eventBooking.dtos.Request.CreateAnEventRequest;
import com.eventBooking.eventBooking.dtos.Request.CreateDiscountForTicketRequest;
import com.eventBooking.eventBooking.dtos.Request.RegisterRequest;
import com.eventBooking.eventBooking.dtos.Response.AddTicketToEventResponse;
import com.eventBooking.eventBooking.dtos.Response.CreateAnEventResponse;
import com.eventBooking.eventBooking.dtos.Response.CreateDiscountForTicketResponse;
import com.eventBooking.eventBooking.dtos.Response.RegisterResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;
@SpringBootTest
class DiscountServiceImplTest {
@Autowired
private OrganizerService organizerService;
@Autowired
private EventService eventService;
@Autowired
private TicketService ticketService;
@Autowired
private DiscountRepository discountRepository;
@Autowired
private DiscountService discountService;

    @Test
    void testThatAnOrganizerCanAddDiscountToTicket() {
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
        CreateAnEventResponse response = eventService.createEvent(createAnEventRequest);

        AddTicketToEventRequest addTicketToEventRequest = new AddTicketToEventRequest();
        addTicketToEventRequest.setTicketType(TicketType.REGULAR);
        addTicketToEventRequest.setId(createAnEventRequest.getId());
        addTicketToEventRequest.setPrice(4000.0);
        addTicketToEventRequest.setAvailableSeats(40);
        addTicketToEventRequest.setTypeOfEvent(response.getEventType());
        AddTicketToEventResponse addTicketToEventResponse = ticketService.addTicketToEvent(addTicketToEventRequest);

        CreateDiscountForTicketRequest createDiscountForTicketRequest = new CreateDiscountForTicketRequest();
        createDiscountForTicketRequest.setPercentage(10);
        createDiscountForTicketRequest.setPrice(4000.0);
        createDiscountForTicketRequest.setId(addTicketToEventResponse.getId());
        CreateDiscountForTicketResponse createDiscountForTicketResponse =  discountService.createDiscountForTicket(createDiscountForTicketRequest);
        assertNotNull(createDiscountForTicketResponse);
        assertTrue(createDiscountForTicketResponse.getMessage().contains("success"));
        assertEquals(1, discountRepository.count());
    }
    @Test
    public void testThrowsExceptionWhenOrganizerTriesToGiveDiscountWithoutTicket(){

    }
}