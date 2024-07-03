package com.eventBooking.eventBooking.data.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Discount {
    @Id
    private Long id;
    private int amount;
    private int percentage;
}
