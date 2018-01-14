package com.github.keraton.triptr.restaurant;

import com.github.keraton.triptr.domain.provider.RestaurantProvider;
import com.github.keraton.triptr.note.NoteProvider;
import com.github.keraton.triptr.restaurant.client.RestaurantProviderClient;
import com.github.keraton.triptr.restaurant.model.Restaurant;
import com.github.keraton.triptr.domain.model.RestaurantTrip;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RestaurantProviderImpl implements RestaurantProvider {

    private final RestaurantProviderClient restaurantProviderClient;
    private final NoteProvider noteProvider;

    public RestaurantProviderImpl(RestaurantProviderClient restaurantProviderClient,
                                  NoteProvider noteProvider) {
        this.restaurantProviderClient = restaurantProviderClient;
        this.noteProvider = noteProvider;
    }

    @Override
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
