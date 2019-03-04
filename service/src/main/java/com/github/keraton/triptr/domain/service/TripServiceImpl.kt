package com.github.keraton.triptr.domain.service

import com.github.keraton.triptr.domain.model.Trip
import com.github.keraton.triptr.domain.service.api.TripService
import com.github.keraton.triptr.hotel.api.HotelProvider
import com.github.keraton.triptr.restaurant.api.RestaurantProvider
import org.springframework.stereotype.Service

@Service
class TripServiceImpl(private val hotelProvider: HotelProvider,
                      private val restaurantProvider: RestaurantProvider) : TripService {

    override fun trip(city: String): Trip {
        return Trip(city, hotelProvider.find(city), restaurantProvider.find(city))
    }
}
