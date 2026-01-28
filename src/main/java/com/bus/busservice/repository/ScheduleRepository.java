package com.bus.busservice.repository;

import com.bus.busservice.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    List<Schedule> findByBus_Id(Long busId);

    List<Schedule> findByBus_Route_SourceAndBus_Route_DestinationAndTravelDate(
            String source,
            String destination,
            String travelDate
    );

}
