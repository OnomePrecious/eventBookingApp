package com.eventBooking.eventBooking.services;

import com.eventBooking.eventBooking.data.models.Discount;
import com.eventBooking.eventBooking.dtos.Request.CreateDiscountForTicketRequest;
import com.eventBooking.eventBooking.dtos.Response.CreateDiscountForTicketResponse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiscountService {
    CreateDiscountForTicketResponse createDiscountForTicket(CreateDiscountForTicketRequest createDiscountForTicketrequest);
}
