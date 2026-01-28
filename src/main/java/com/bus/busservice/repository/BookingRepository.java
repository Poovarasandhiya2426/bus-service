package com.bus.busservice.repository;

import com.bus.busservice.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findByUserId(Long userId);

    @Query("""
    SELECT COALESCE(SUM(b.seatsBooked), 0)
    FROM Booking b
    WHERE b.schedule.id = :scheduleId
    AND b.status = 'CONFIRMED'
""")
    int getTotalBookedSeats(@Param("scheduleId") Long scheduleId);
}
