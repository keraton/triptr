package com.github.keraton.triptr.restaurant.mapper;

import com.github.keraton.triptr.domain.model.RestaurantTrip;
import com.github.keraton.triptr.note.api.NoteProvider;
import com.github.keraton.triptr.restaurant.model.Restaurant;
import org.springframework.stereotype.Component;

@Component
public class RestaurantMapper {

    private final NoteProvider noteProvider;

    public RestaurantMapper(NoteProvider noteProvider) {
        this.noteProvider = noteProvider;
    }

    public RestaurantTrip map(Restaurant restaurant) {
        return new RestaurantTrip(restaurant.getRefId(), restaurant.getName(), restaurant.getCity(), noteProvider.getNote(restaurant.getRefId()));
    }
}
