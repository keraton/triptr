package com.github.keraton.triptr.web.controller

import com.github.keraton.triptr.domain.model.Trip
import com.github.keraton.triptr.domain.service.api.TripService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class TriptrController(private val tripService: TripService) {

    @GetMapping("/city/{cityName}")
    fun trip(@PathVariable cityName: String): Trip {
        return tripService.trip(cityName)
    }
}
