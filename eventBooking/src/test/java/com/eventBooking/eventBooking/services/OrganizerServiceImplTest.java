package com.eventBooking.eventBooking.services;

import com.eventBooking.eventBooking.data.models.EventType;
import com.eventBooking.eventBooking.data.models.TicketType;
import com.eventBooking.eventBooking.data.repositories.EventRepository;
import com.eventBooking.eventBooking.data.repositories.GuestRepository;
import com.eventBooking.eventBooking.data.repositories.OrganizerRepository;
import com.eventBooking.eventBooking.dtos.Request.CreateAnEventRequest;
import com.eventBooking.eventBooking.dtos.Request.CreateGuestListRequest;
import com.eventBooking.eventBooking.dtos.Request.RegisterRequest;
import com.eventBooking.eventBooking.dtos.Response.CreateAnEventResponse;
import com.eventBooking.eventBooking.dtos.Response.CreateGuestListResponse;
import com.eventBooking.eventBooking.dtos.Response.RegisterResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class OrganizerServiceImplTest {
    @Autowired
    private OrganizerService organizerService;
    @Autowired
    private OrganizerRepository organizerRepository;
    @Autowired
    private EventService eventService;
    @Autowired
    private GuestRepository guestRepository;

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
    @Test
    public void testThatAnOrganizerCanAddToGuestList(){
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

        CreateGuestListRequest addToGuestList = new CreateGuestListRequest();
        addToGuestList.setEventId(response.getId());
        addToGuestList.setGuestName("John Doe");
        addToGuestList.setTicketType(TicketType.VVIP);
        CreateGuestListResponse addToGuestListResponse = organizerService.createGuestList(addToGuestList);
        assertNotNull(addToGuestListResponse);
        assertTrue(addToGuestListResponse.getMessage().contains("success"));
        assertThat(addToGuestListResponse.getNumberOfGuest()).isEqualTo(1);
        assertEquals(1, guestRepository.count());


}
    @Test
    public void testThatAnOrganizerCanAddMoreGuestToGuestList() {
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setUsername("my username");
        registerRequest.setEmail("myname@gmail.com");
        registerRequest.setPassword("my password");
        RegisterResponse organizer = organizerService.registerOrganizer(registerRequest);

        CreateAnEventRequest createAnEventRequest = new CreateAnEventRequest();
        createAnEventRequest.setId(organizer.getId());
        createAnEventRequest.setTypeOfEvent(EventType.FESTIVAL);
        createAnEventRequest.setAddress("Lagos");
        createAnEventRequest.setNumberOfTickets(50);
        createAnEventRequest.setNumberOfGuest(50);
        CreateAnEventResponse response = eventService.createEvent(createAnEventRequest);

        CreateGuestListRequest addToGuestList = new CreateGuestListRequest();
        addToGuestList.setEventId(response.getId());
        addToGuestList.setGuestName("Jane Doe");
        addToGuestList.setTicketType(TicketType.VVIP);

        CreateGuestListResponse createGuestListResponse = organizerService.createGuestList(addToGuestList);
     assertNotNull(createGuestListResponse.getMessage());
        assertTrue(createGuestListResponse.getMessage().contains("success"));
        assertThat(createGuestListResponse.getNumberOfGuest()).isEqualTo(1);
        assertEquals(1, guestRepository.count());


    }




    }

