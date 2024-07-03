package com.eventBooking.eventBooking.services;

import com.eventBooking.eventBooking.data.models.Organizer;
import com.eventBooking.eventBooking.dtos.Request.AddTicketToEventRequest;
import com.eventBooking.eventBooking.dtos.Request.CreateAnEventRequest;
import com.eventBooking.eventBooking.dtos.Request.RegisterRequest;
import com.eventBooking.eventBooking.dtos.Response.AddTicketToEventResponse;
import com.eventBooking.eventBooking.dtos.Response.CreateAnEventResponse;
import com.eventBooking.eventBooking.dtos.Response.RegisterResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
@Service
public class OrganizerServiceImpl implements OrganizerService {
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    @Autowired
    public OrganizerServiceImpl(ModelMapper modelMapper, PasswordEncoder passwordEncoder){
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
    }
    @Override
    public RegisterResponse registerOrganizer(RegisterRequest registerRequest) {
        Organizer organizer = modelMapper.map(registerRequest, Organizer.class);
        organizer.setUsername(registerRequest.getUsername());
        organizer.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        organizer.setEmail(registerRequest.getEmail());
        RegisterResponse registerResponse = modelMapper.map(registerRequest, RegisterResponse.class);
        registerResponse.setMessage("Registration successful");
        return registerResponse;



    }

    @Override
    public CreateAnEventResponse createEvent(CreateAnEventRequest createEventRequest) {
        return null;
    }

    @Override
    public AddTicketToEventResponse addTicketToEvent(AddTicketToEventRequest addTicketToEventRequest) {
        return null;
    }

}
