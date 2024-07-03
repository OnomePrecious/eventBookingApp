package com.eventBooking.eventBooking.data.models;

import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Guest {
    private Long id;
    private String name;
    @ManyToOne
    private Organizer organizer;
}
