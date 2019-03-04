package com.github.keraton.triptr.restaurant.client;

import com.github.keraton.triptr.restaurant.model.Restaurant;
import org.springframework.stereotype.Repository;

import java.util.List;

import static java.util.Arrays.asList;

@Repository
public class RestaurantProviderClient {

    private static final String FOUQUET_S = "Fouquet's";
    private static final String LA_ROTONDE = "La Rotonde";
    private static final String LE_CINQ = "Le Cinq";

    public List<Restaurant> find(String city) {
        return asList(
                new Restaurant("R001", FOUQUET_S, city),
                new Restaurant("R002", LA_ROTONDE, city),
                new Restaurant("R003", LE_CINQ, city)
        );
    }
}
