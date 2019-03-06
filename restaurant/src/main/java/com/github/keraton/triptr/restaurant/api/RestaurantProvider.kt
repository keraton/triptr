package com.github.keraton.triptr.restaurant.api

import com.github.keraton.triptr.domain.model.RestaurantTrip

interface RestaurantProvider {
    fun find(city: String): List<RestaurantTrip>
}
