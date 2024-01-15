package dev.triamylo.workingplacebooking.repository;

import dev.triamylo.workingplacebooking.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, String> {
}
