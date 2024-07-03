package com.eventBooking.eventBooking.data.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@Entity
@ToString
@Table(name="events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private EventType typeOfEvent;
    private String address;
    private int numberOfTickets;
//    @OneToMany
//    private List<Ticket> tickets= new ArrayList<>();
    @ManyToOne
    private Organizer organizer;
}
