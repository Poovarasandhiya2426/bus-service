package com.bus.busservice.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "schedules")
@Data
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String travelDate;      // 2026-01-30
    private String departureTime;   // 22:00
    private String arrivalTime;     // 06:00

    @ManyToOne
    @JoinColumn(name = "bus_id")
    private Bus bus;
}
