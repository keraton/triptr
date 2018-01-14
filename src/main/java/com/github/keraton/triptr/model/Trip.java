package com.github.keraton.triptr.model;

import lombok.Data;

import java.util.List;

public @Data class Trip {

    private String city;
    private List<HotelTrip> hotels;
    private List<RestaurantTrip> restaurants;
}
