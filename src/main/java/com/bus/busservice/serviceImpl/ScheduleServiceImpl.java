package com.bus.busservice.serviceImpl;

import com.bus.busservice.dto.ScheduleResponse;
import com.bus.busservice.exception.ResourceNotFoundException;
import com.bus.busservice.model.Bus;
import com.bus.busservice.model.Schedule;
import com.bus.busservice.repository.BusRepository;
import com.bus.busservice.repository.ScheduleRepository;
import com.bus.busservice.service.ScheduleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final BusRepository busRepository;

    public ScheduleServiceImpl(ScheduleRepository scheduleRepository,
                               BusRepository busRepository) {
        this.scheduleRepository = scheduleRepository;
        this.busRepository = busRepository;
    }

    @Override
    public Schedule addSchedule(Long busId, Schedule schedule) {
        Bus bus = busRepository.findById(busId)
                .orElseThrow(() -> new ResourceNotFoundException("Bus not found"));

        schedule.setBus(bus);
        return scheduleRepository.save(schedule);
    }

    @Override
    public List<ScheduleResponse> getSchedulesByBus(Long busId) {

        List<Schedule> schedules = scheduleRepository.findByBus_Id(busId);

        return schedules.stream().map(schedule -> {

            ScheduleResponse response = new ScheduleResponse();

            response.setScheduleId(schedule.getId());
            response.setTravelDate(schedule.getTravelDate());
            response.setDepartureTime(schedule.getDepartureTime());
            response.setArrivalTime(schedule.getArrivalTime());

            response.setBusId(schedule.getBus().getId());
            response.setBusNumber(schedule.getBus().getBusNumber());
            response.setBusType(schedule.getBus().getBusType());

            response.setSource(schedule.getBus().getRoute().getSource());
            response.setDestination(schedule.getBus().getRoute().getDestination());

            return response;

        }).toList();
    }


    @Override
    public List<ScheduleResponse> searchSchedules(String source,
                                                  String destination,
                                                  String travelDate) {

        List<Schedule> schedules =
                scheduleRepository
                        .findByBus_Route_SourceAndBus_Route_DestinationAndTravelDate(
                                source, destination, travelDate
                        );

        return schedules.stream().map(schedule -> {

            ScheduleResponse response = new ScheduleResponse();

            response.setScheduleId(schedule.getId());
            response.setTravelDate(schedule.getTravelDate());
            response.setDepartureTime(schedule.getDepartureTime());
            response.setArrivalTime(schedule.getArrivalTime());

            response.setBusId(schedule.getBus().getId());
            response.setBusNumber(schedule.getBus().getBusNumber());
            response.setBusType(schedule.getBus().getBusType());

            response.setSource(schedule.getBus().getRoute().getSource());
            response.setDestination(schedule.getBus().getRoute().getDestination());

            return response;

        }).toList();
    }
}
