package com.github.keraton.triptr.restaurant.client;

import com.github.keraton.triptr.restaurant.model.Restaurant;
import org.springframework.stereotype.Repository;

import java.util.List;

import static java.util.Arrays.asList;

@Repository
public class RestaurantProviderClient {
    public List<Restaurant> find(String city) {
        return asList(
                new Restaurant("R001", "Fouquet's", city),
                new Restaurant("R002", "La Rotonde", city),
                new Restaurant("R003", "Le Cinq", city)
        );
    }
}
