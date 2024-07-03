package com.eventBooking.eventBooking.dtos.Request;

import com.eventBooking.eventBooking.data.models.TicketType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateDiscountForTicketRequest {
    private Long id;
    private double price;
    private int percentage;
    private TicketType ticketType;



}
