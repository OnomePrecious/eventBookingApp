package com.eventBooking.eventBooking.services;

import com.eventBooking.eventBooking.data.models.Guest;
import com.eventBooking.eventBooking.data.models.Organizer;
import com.eventBooking.eventBooking.data.repositories.GuestRepository;
import com.eventBooking.eventBooking.data.repositories.OrganizerRepository;
import com.eventBooking.eventBooking.dtos.Request.CreateGuestListRequest;
import com.eventBooking.eventBooking.dtos.Request.RegisterRequest;
import com.eventBooking.eventBooking.dtos.Response.CreateGuestListResponse;
import com.eventBooking.eventBooking.dtos.Response.RegisterResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
@Service
public class OrganizerServiceImpl implements OrganizerService {
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final OrganizerRepository organizerRepository;
    private final GuestRepository guestRepository;

    @Autowired
    public OrganizerServiceImpl(ModelMapper modelMapper, PasswordEncoder passwordEncoder, OrganizerRepository organizerRepository, GuestRepository guestRepository) {
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
        this.organizerRepository = organizerRepository;
        this.guestRepository = guestRepository;
    }

    @Override
    public RegisterResponse registerOrganizer(RegisterRequest registerRequest) {
        Organizer organizer = modelMapper.map(registerRequest, Organizer.class);
        organizer.setUsername(registerRequest.getUsername());
        organizer.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        organizer.setEmail(registerRequest.getEmail());
        organizer = organizerRepository.save(organizer);
        RegisterResponse registerResponse = modelMapper.map(organizer, RegisterResponse.class);
        registerResponse.setMessage("Registration successful");
        return registerResponse;



    }

    @Override
    public CreateGuestListResponse createGuestList(CreateGuestListRequest createGuestListRequest) {
        Guest guest = new Guest();
        guest.setName(createGuestListRequest.getGuestName());
        guest.setOrganizerId(createGuestListRequest.getGuestId());
        guestRepository.save(guest);
        var guests = guestRepository.findGuestsByGuestId(createGuestListRequest.getGuestId());
        CreateGuestListResponse createGuestListResponse = new CreateGuestListResponse();
        createGuestListResponse.setNumberOfGuest(guests.size());
        createGuestListResponse.setMessage("Guest list created successfully");
        return createGuestListResponse;
    }
}