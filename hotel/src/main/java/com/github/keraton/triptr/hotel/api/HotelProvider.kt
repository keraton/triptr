package com.github.keraton.triptr.hotel.api

import com.github.keraton.triptr.domain.model.HotelTrip

interface HotelProvider {
    fun find(city: String): List<HotelTrip>
}
