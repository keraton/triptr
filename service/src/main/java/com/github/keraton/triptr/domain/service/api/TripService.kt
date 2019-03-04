package com.github.keraton.triptr.domain.service.api

import com.github.keraton.triptr.domain.model.Trip

interface TripService {
    fun trip(city: String): Trip
}
