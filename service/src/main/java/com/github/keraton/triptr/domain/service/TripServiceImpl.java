package com.github.keraton.triptr.domain.service;

import com.github.keraton.triptr.domain.model.Trip;
import com.github.keraton.triptr.domain.service.api.TripService;
import com.github.keraton.triptr.hotel.api.HotelProvider;
import com.github.keraton.triptr.restaurant.api.RestaurantProvider;
import org.springframework.stereotype.Service;

@Service
public class TripServiceImpl implements TripService {

    private final HotelProvider hotelProvider;
    private final RestaurantProvider restaurantProvider;

    public TripServiceImpl(HotelProvider hotelProvider,
                           RestaurantProvider restaurantProvider) {
        this.hotelProvider = hotelProvider;
        this.restaurantProvider = restaurantProvider;
    }

    @Override
    public Trip trip(String city) {
        Trip trip = new Trip();
        trip.setCity(city);
        trip.setHotels(hotelProvider.find(city));
        trip.setRestaurants(restaurantProvider.find(city));
        return trip;
    }
}
