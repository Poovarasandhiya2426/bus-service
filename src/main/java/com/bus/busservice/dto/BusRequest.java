package com.bus.busservice.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class BusRequest {

    @NotBlank
    private String busNumber;

    @NotBlank
    private String busType;   // AC / Non-AC / Sleeper

    @Min(1)
    private int totalSeats;
}
