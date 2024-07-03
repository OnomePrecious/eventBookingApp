package com.eventBooking.eventBooking.dtos.Response;

import com.eventBooking.eventBooking.data.models.Guest;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class CreateGuestListResponse {
    private Long id;
    private int numberOfGuest;
    private String message;
}
