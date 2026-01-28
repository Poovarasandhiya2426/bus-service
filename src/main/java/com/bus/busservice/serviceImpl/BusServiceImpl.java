package com.bus.busservice.serviceImpl;

import com.bus.busservice.dto.BusRequest;
import com.bus.busservice.model.Bus;
import com.bus.busservice.repository.BusRepository;
import com.bus.busservice.service.BusService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusServiceImpl implements BusService {

    private final BusRepository busRepository;

    public BusServiceImpl(BusRepository busRepository) {
        this.busRepository = busRepository;
    }

    @Override
    public Bus addBus(BusRequest request) {
        Bus bus = new Bus();
        bus.setBusNumber(request.getBusNumber());
        bus.setBusType(request.getBusType());
        bus.setTotalSeats(request.getTotalSeats());
        return busRepository.save(bus);
    }

    @Override
    public List<Bus> getAllBuses() {
        return busRepository.findAll();
    }


    @Override
    public Bus saveBus(Bus bus) {
        return busRepository.save(bus);
    }

    @Override
    public List<Bus> getBusesByRoute(Long routeId) {
        return busRepository.findByRoute_Id(routeId);


    }
}