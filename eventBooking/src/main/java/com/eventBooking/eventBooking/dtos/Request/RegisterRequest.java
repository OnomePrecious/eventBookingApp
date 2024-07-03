package com.eventBooking.eventBooking.dtos.Request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequest {
    private Long organizerId;
    private String username;
    private String email;
    private String password;

}
