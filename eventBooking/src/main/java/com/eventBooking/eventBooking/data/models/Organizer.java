package com.eventBooking.eventBooking.data.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

    @Entity
    @Table(name = "organizers")
    @Setter
    @Getter
    @NoArgsConstructor
    public class Organizer {
        @Id
        @GeneratedValue(strategy = IDENTITY)
        private Long id;
        private String username;
        @Column(unique = true)
        private String email;
        private String password;
        @ElementCollection
        @Enumerated(EnumType.STRING)
        private List<EventType> event;


    }
