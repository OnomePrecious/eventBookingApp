package com.eventBooking.eventBooking.data.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "guests")
public class Guest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long organizerId;
    private String name;
    @ManyToOne
    private Organizer organizer;
}
