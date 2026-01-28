package com.bus.busservice.controller;

import com.bus.busservice.model.Booking;
import com.bus.busservice.service.BookingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    // Create booking
    @PostMapping("/schedule/{scheduleId}")
    public Booking createBooking(@PathVariable Long scheduleId,
                                 @RequestBody Booking booking) {
        return bookingService.createBooking(scheduleId, booking);
    }

    // Get bookings by user
    @GetMapping("/user/{userId}")
    public List<Booking> getBookingsByUser(@PathVariable Long userId) {
        return bookingService.getBookingsByUser(userId);
    }

    @PutMapping("/{bookingId}/confirm")
    public Booking confirmBooking(@PathVariable Long bookingId) {
        return bookingService.confirmBooking(bookingId);
    }
}
