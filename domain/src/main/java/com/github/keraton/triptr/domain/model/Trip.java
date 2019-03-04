package com.github.keraton.triptr.domain.model;

import lombok.Value;

import java.util.List;

public @Value class Trip {

    private String city;
    private List<HotelTrip> hotels;
    private List<RestaurantTrip> restaurants;
}
