package com.github.keraton.triptr.web.controller;

import com.github.keraton.triptr.domain.model.Trip;
import com.github.keraton.triptr.domain.service.TripService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TriptrController {

    private final TripService tripService;

    public TriptrController(TripService tripService) {
        this.tripService = tripService;
    }

    @GetMapping("/city/{cityName}")
    public Trip trip(@PathVariable String cityName) {
        return tripService.trip(cityName);
    }
}
