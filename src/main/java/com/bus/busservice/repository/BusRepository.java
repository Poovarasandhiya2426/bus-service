package com.bus.busservice.repository;

import com.bus.busservice.model.Bus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BusRepository extends JpaRepository<Bus, Long> {

    List<Bus> findByRoute_Id(Long routeId);

}


