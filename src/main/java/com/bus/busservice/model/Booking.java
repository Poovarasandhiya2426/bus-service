package com.bus.busservice.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "bookings")
@Data
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;          // from User Service
    private int seatsBooked;      // simple count
    private String status;        // PENDING / CONFIRMED

    @ManyToOne
    @JoinColumn(name = "schedule_id")
    private Schedule schedule;
}
