package com.github.keraton.triptr.domain.model;

import com.github.keraton.triptr.restaurant.mapper.RestaurantMapper;
import com.github.keraton.triptr.restaurant.model.Restaurant;
import lombok.Data;

public @Data class RestaurantTrip {

    private final String refId;
    private final String name;
    private final String city;
    private NoteTrip note;

    public static RestaurantTrip convert(Restaurant restaurant) {
        return RestaurantMapper.map(restaurant);
    }
}
