package com.bus.busservice.service;

import com.bus.busservice.dto.ScheduleResponse;
import com.bus.busservice.model.Schedule;

import java.util.List;

public interface ScheduleService {

    Schedule addSchedule(Long busId, Schedule schedule);
    List<ScheduleResponse> getSchedulesByBus(Long busId);

    List<ScheduleResponse> searchSchedules(String source, String destination, String travelDate);

}
