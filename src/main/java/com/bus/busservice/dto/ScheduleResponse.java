package com.bus.busservice.dto;

import lombok.Data;

@Data
public class ScheduleResponse {

    private Long scheduleId;
    private String travelDate;
    private String departureTime;
    private String arrivalTime;

    private Long busId;
    private String busNumber;
    private String busType;

    private String source;
    private String destination;
}
