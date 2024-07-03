package com.eventBooking.eventBooking.services;

import com.eventBooking.eventBooking.data.models.Event;
import com.eventBooking.eventBooking.data.models.Organizer;
import com.eventBooking.eventBooking.data.models.Ticket;
import com.eventBooking.eventBooking.data.repositories.EventRepository;
import com.eventBooking.eventBooking.data.repositories.OrganizerRepository;
import com.eventBooking.eventBooking.data.repositories.TicketRepository;
import com.eventBooking.eventBooking.dtos.Request.AddTicketToEventRequest;
import com.eventBooking.eventBooking.dtos.Response.AddTicketToEventResponse;
import com.eventBooking.eventBooking.exception.NoExistingEventException;
import com.eventBooking.eventBooking.exception.OrganizerDoesNotExistException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TicketServiceImpl implements TicketService{
    private final EventRepository eventRepository;
    private final ModelMapper modelMapper;
    private final TicketRepository ticketRepository;
    private final OrganizerRepository organizationRepository;
    @Override
    public AddTicketToEventResponse addTicketToEvent(AddTicketToEventRequest addTicketToEventRequest) {
        Ticket ticket = new Ticket();
        Organizer organizer = organizationRepository.findById(addTicketToEventRequest.getId()).orElseThrow(()-> new OrganizerDoesNotExistException("No organizer available"));
        Event event = eventRepository.findById(addTicketToEventRequest.getId()).orElseThrow(()-> new NoExistingEventException("No events available to add tickets"));
        modelMapper.map(ticket, addTicketToEventRequest);
        eventRepository.save(event);
        ticketRepository.save(ticket);
        organizationRepository.save(organizer);
        AddTicketToEventResponse addTicketToEventResponse = modelMapper.map(ticket, AddTicketToEventResponse.class);
        addTicketToEventResponse.setMessage("Ticket added successfully");
        return addTicketToEventResponse;
    }
}
