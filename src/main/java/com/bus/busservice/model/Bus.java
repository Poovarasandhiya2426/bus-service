package com.bus.busservice.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "buses")
@Data
public class Bus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String busNumber;
    private String busType;      // AC / Non-AC / Sleeper
    private int totalSeats;

    @ManyToOne
    @JoinColumn(name = "route_id")
    private Route route;
}
