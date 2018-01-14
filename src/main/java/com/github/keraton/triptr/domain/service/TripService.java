package com.github.keraton.triptr.domain.service;

import com.github.keraton.triptr.domain.model.Trip;
import com.github.keraton.triptr.domain.provider.HotelProvider;
import com.github.keraton.triptr.domain.provider.RestaurantProvider;
import org.springframework.stereotype.Service;

@Service
public class TripService {

    private final HotelProvider hotelProvider;
    private final RestaurantProvider restaurantProvider;

    public TripService(HotelProvider hotelProvider,
                       RestaurantProvider restaurantProvider) {
        this.hotelProvider = hotelProvider;
        this.restaurantProvider = restaurantProvider;
    }

    public Trip trip(String city) {
        Trip trip = new Trip();
        trip.setCity(city);
        trip.setHotels(hotelProvider.find(city));
        trip.setRestaurants(restaurantProvider.find(city));


        return trip;
    }
}
