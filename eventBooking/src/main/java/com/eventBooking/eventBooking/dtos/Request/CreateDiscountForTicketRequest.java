package com.eventBooking.eventBooking.dtos.Request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateDiscountForTicketRequest {
    private Long id;
    private double price;
    private int percentage;



}
