package com.bus.busservice.service;

import com.bus.busservice.model.Booking;

import java.util.List;

public interface BookingService {

    Booking createBooking(Long scheduleId, Booking booking);

    List<Booking> getBookingsByUser(Long userId);

    Booking confirmBooking(Long bookingId);

}
