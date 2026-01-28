package com.bus.busservice.serviceImpl;

import com.bus.busservice.exception.ResourceNotFoundException;
import com.bus.busservice.model.Booking;
import com.bus.busservice.model.Schedule;
import com.bus.busservice.repository.BookingRepository;
import com.bus.busservice.repository.ScheduleRepository;
import com.bus.busservice.service.BookingService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final ScheduleRepository scheduleRepository;

    public BookingServiceImpl(BookingRepository bookingRepository,
                              ScheduleRepository scheduleRepository) {
        this.bookingRepository = bookingRepository;
        this.scheduleRepository = scheduleRepository;
    }

    @Override
    public Booking createBooking(Long scheduleId, Booking booking) {

        Schedule schedule = scheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new ResourceNotFoundException("Schedule not found"));

        int bookedSeats =
                bookingRepository.getTotalBookedSeats(scheduleId);

        int totalSeats = schedule.getBus().getTotalSeats();
        int availableSeats = totalSeats - bookedSeats;

        if (booking.getSeatsBooked() > availableSeats) {
            throw new ResourceNotFoundException("Not enough seats available");
        }

        booking.setSchedule(schedule);
        booking.setStatus("PENDING");
        return bookingRepository.save(booking);
    }

    @Override
    public List<Booking> getBookingsByUser(Long userId) {
        return bookingRepository.findByUserId(userId);
    }

    @Override
    public Booking confirmBooking(Long bookingId) {

        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new ResourceNotFoundException("Booking not found"));

        // Payment simulation success
        booking.setStatus("CONFIRMED");

        return bookingRepository.save(booking);
    }

}
