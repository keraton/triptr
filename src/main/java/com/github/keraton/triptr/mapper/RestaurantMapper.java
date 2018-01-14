package com.github.keraton.triptr.mapper;

import com.github.keraton.triptr.model.Restaurant;
import com.github.keraton.triptr.model.RestaurantTrip;
import org.springframework.stereotype.Component;

@Component
public class RestaurantMapper {

    public static RestaurantTrip map(Restaurant restaurant) {
        return new RestaurantTrip(restaurant.getRefId(), restaurant.getName(), restaurant.getCity());
    }
}
