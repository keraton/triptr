package com.github.keraton.triptr.restaurant.mapper;

import com.github.keraton.triptr.restaurant.model.Restaurant;
import com.github.keraton.triptr.domain.model.RestaurantTrip;
import org.springframework.stereotype.Component;

public class RestaurantMapper {

    public RestaurantTrip map(Restaurant restaurant) {
        return new RestaurantTrip(restaurant.getRefId(), restaurant.getName(), restaurant.getCity());
    }
}
