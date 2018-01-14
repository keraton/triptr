package com.github.keraton.triptr.restaurant;

import com.github.keraton.triptr.note.NoteProvider;
import com.github.keraton.triptr.restaurant.client.RestaurantProviderClient;
import com.github.keraton.triptr.restaurant.model.Restaurant;
import com.github.keraton.triptr.domain.model.model.RestaurantTrip;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RestaurantProvider {

    private final RestaurantProviderClient restaurantProviderClient;
    private final NoteProvider noteProvider;

    public RestaurantProvider(RestaurantProviderClient restaurantProviderClient,
                              NoteProvider noteProvider) {
        this.restaurantProviderClient = restaurantProviderClient;
        this.noteProvider = noteProvider;
    }

    public List<RestaurantTrip> find(String city) {
        List<Restaurant> restaurants = restaurantProviderClient.find(city);
        return restaurants.stream()
                .map(RestaurantTrip::convert)
                .map(restaurantTrip -> {
                    restaurantTrip.setNote(noteProvider.getNote(restaurantTrip.getRefId()));
                    return restaurantTrip;
                })
                .collect(Collectors.toList());
    }
}
