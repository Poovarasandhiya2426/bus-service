package com.bus.busservice.service;

import com.bus.busservice.dto.BusRequest;
import com.bus.busservice.model.Bus;

import java.util.List;

public interface BusService {
    Bus addBus(BusRequest request);
    List<Bus> getAllBuses();
    Bus saveBus(Bus bus);

    List<Bus> getBusesByRoute(Long routeId);

}
