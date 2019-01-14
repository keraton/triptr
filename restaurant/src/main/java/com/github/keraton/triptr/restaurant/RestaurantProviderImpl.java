package com.github.keraton.triptr.restaurant;

import com.github.keraton.triptr.domain.model.RestaurantTrip;
import com.github.keraton.triptr.restaurant.api.RestaurantProvider;
import com.github.keraton.triptr.note.api.NoteProvider;
import com.github.keraton.triptr.restaurant.client.RestaurantProviderClient;
import com.github.keraton.triptr.restaurant.mapper.RestaurantMapper;
import com.github.keraton.triptr.restaurant.model.Restaurant;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RestaurantProviderImpl implements RestaurantProvider {

    private final RestaurantProviderClient restaurantProviderClient;
    private final NoteProvider noteProvider;
    private final RestaurantMapper restaurantMapper;

    public RestaurantProviderImpl(RestaurantProviderClient restaurantProviderClient,
                                  NoteProvider noteProvider,
                                  RestaurantMapper restaurantMapper) {
        this.restaurantProviderClient = restaurantProviderClient;
        this.noteProvider = noteProvider;
        this.restaurantMapper = restaurantMapper;
    }

    @Override
    public List<RestaurantTrip> find(String city) {
        List<Restaurant> restaurants = restaurantProviderClient.find(city);
        return restaurants.stream()
                .map(restaurantMapper::map)
                .map(restaurantTrip -> {
                    restaurantTrip.setNote(noteProvider.getNote(restaurantTrip.getRefId()));
                    return restaurantTrip;
                })
                .collect(Collectors.toList());
    }
}
