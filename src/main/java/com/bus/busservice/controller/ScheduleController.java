package com.bus.busservice.controller;

import com.bus.busservice.dto.ScheduleResponse;
import com.bus.busservice.model.Schedule;
import com.bus.busservice.service.ScheduleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedules")
public class ScheduleController {

    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    // Add schedule for a bus
    @PostMapping("/bus/{busId}")
    public Schedule addSchedule(@PathVariable Long busId,
                                @RequestBody Schedule schedule) {
        return scheduleService.addSchedule(busId, schedule);
    }

    // Get schedules by bus
    @GetMapping("/bus/{busId}")
    public List<ScheduleResponse> getSchedulesByBus(@PathVariable Long busId) {
        return scheduleService.getSchedulesByBus(busId);
    }

    @GetMapping("/search")
    public List<ScheduleResponse> searchSchedules(
            @RequestParam String source,
            @RequestParam String destination,
            @RequestParam String travelDate) {

        return scheduleService.searchSchedules(source, destination, travelDate);
    }
}
