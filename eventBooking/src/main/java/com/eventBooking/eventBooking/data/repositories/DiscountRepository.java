package com.eventBooking.eventBooking.data.repositories;

import com.eventBooking.eventBooking.data.models.Discount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiscountRepository extends JpaRepository<Discount, Long> {
}
