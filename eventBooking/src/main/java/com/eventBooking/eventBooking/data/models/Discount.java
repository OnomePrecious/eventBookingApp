package com.eventBooking.eventBooking.data.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString
@Table(name ="discount")
public class Discount {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int amount;
    private int percentage;
    @OneToOne
    private Ticket ticket;
}
