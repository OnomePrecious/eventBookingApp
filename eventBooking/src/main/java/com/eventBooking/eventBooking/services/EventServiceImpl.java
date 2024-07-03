package com.eventBooking.eventBooking.services;

import com.eventBooking.eventBooking.data.models.Event;
import com.eventBooking.eventBooking.data.models.Organizer;
import com.eventBooking.eventBooking.data.repositories.EventRepository;
import com.eventBooking.eventBooking.data.repositories.OrganizerRepository;
import com.eventBooking.eventBooking.dtos.Request.CreateAnEventRequest;
import com.eventBooking.eventBooking.dtos.Response.CreateAnEventResponse;
import com.eventBooking.eventBooking.exception.OrganizerDoesNotExistException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EventServiceImpl implements EventService{
    private final EventRepository eventRepository;
    private final OrganizerRepository organizerRepository;
    private final ModelMapper modelMapper;
    @Override
    public CreateAnEventResponse createEvent(CreateAnEventRequest createEventRequest) {
        Event event = new Event();
        Organizer organizer = organizerRepository.findById(createEventRequest.getId())
                .orElseThrow(()->new OrganizerDoesNotExistException("No organizer to create event"));
        event.setTypeOfEvent(createEventRequest.getTypeOfEvent());
        event.setAddress(createEventRequest.getAddress());
        event.setNumberOfTickets(createEventRequest.getNumberOfTickets());
        event.setOrganizer(organizer);
        event=eventRepository.save(event);
        CreateAnEventResponse createEventResponse = modelMapper.map(event, CreateAnEventResponse.class);

        createEventResponse.setMessage("Event created successfully");
        return createEventResponse;
    }
}
