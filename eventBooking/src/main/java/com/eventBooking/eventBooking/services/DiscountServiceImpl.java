package com.eventBooking.eventBooking.services;

import com.eventBooking.eventBooking.data.models.Discount;
import com.eventBooking.eventBooking.data.models.Organizer;
import com.eventBooking.eventBooking.data.models.Ticket;
import com.eventBooking.eventBooking.data.repositories.DiscountRepository;
import com.eventBooking.eventBooking.data.repositories.EventRepository;
import com.eventBooking.eventBooking.data.repositories.OrganizerRepository;
import com.eventBooking.eventBooking.data.repositories.TicketRepository;
import com.eventBooking.eventBooking.dtos.Request.CreateDiscountForTicketRequest;
import com.eventBooking.eventBooking.dtos.Response.CreateDiscountForTicketResponse;
import com.eventBooking.eventBooking.exception.NoTicketsAvailableException;
import com.eventBooking.eventBooking.exception.OrganizerDoesNotExistException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DiscountServiceImpl implements DiscountService{
    private final TicketRepository ticketRepository;
    private final DiscountRepository discountRepository;
    private final OrganizerRepository organizerRepository;
    private ModelMapper modelMapper;


    @Override
    public CreateDiscountForTicketResponse createDiscountForTicket(CreateDiscountForTicketRequest createDiscountForTicketrequest) {
        Discount discount = new Discount();
        Organizer organizer = organizerRepository.findById(createDiscountForTicketrequest.getOrganizerId()).orElseThrow(()-> new OrganizerDoesNotExistException("No organizer available"));
        Ticket ticket = ticketRepository.findById(createDiscountForTicketrequest.getId()).orElseThrow(()-> new NoTicketsAvailableException("No tickets available for discount"));
        modelMapper.map(discount, createDiscountForTicketrequest);
        discountRepository.save(discount);
        ticketRepository.save(ticket);
        organizerRepository.save(organizer);
        CreateDiscountForTicketResponse createDiscountForTicketResponse = modelMapper.map(discount, CreateDiscountForTicketResponse.class);
        createDiscountForTicketResponse.setMessage("Discount successfully set");
        return createDiscountForTicketResponse;
    }
}
