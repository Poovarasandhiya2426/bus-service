package com.bus.busservice.controller;

import com.bus.busservice.dto.BusRequest;
import com.bus.busservice.model.Bus;
import com.bus.busservice.model.Route;
import com.bus.busservice.repository.RouteRepository;
import com.bus.busservice.service.BusService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/buses")
public class BusController {

    private final BusService busService;
    private final RouteRepository routeRepository;


    public BusController(BusService busService, RouteRepository routeRepository) {
        this.busService = busService;
        this.routeRepository = routeRepository;
    }

    @PostMapping
    public Bus addBus(@Valid @RequestBody BusRequest request) {
        return busService.addBus(request);
    }

    @GetMapping
    public List<Bus> getAllBuses() {
        return busService.getAllBuses();
    }

    @PostMapping("/route/{routeId}")
    public Bus addBusWithRoute(@PathVariable Long routeId,
                               @RequestBody Bus bus) {

        Route route = routeRepository.findById(routeId)
                .orElseThrow(() -> new RuntimeException("Route not found"));

        bus.setRoute(route);
        return busService.saveBus(bus);
    }

    @GetMapping("/route/{routeId}")
    public List<Bus> getBusesByRoute(@PathVariable Long routeId) {
        return busService.getBusesByRoute(routeId);
    }




}

