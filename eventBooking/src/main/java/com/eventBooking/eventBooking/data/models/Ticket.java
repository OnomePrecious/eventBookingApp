package com.eventBooking.eventBooking.data.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tickets")
public class Ticket {
    @Id
    private Long id;
    private TicketType ticketType;
    private Double price;
    private EventType event;



}
