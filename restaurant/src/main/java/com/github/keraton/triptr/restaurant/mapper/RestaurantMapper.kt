package com.github.keraton.triptr.restaurant.mapper

import com.github.keraton.triptr.domain.model.RestaurantTrip
import com.github.keraton.triptr.note.api.NoteProvider
import com.github.keraton.triptr.restaurant.model.Restaurant
import org.springframework.stereotype.Component

@Component
class RestaurantMapper(private val noteProvider: NoteProvider) {

    fun map(restaurant: Restaurant): RestaurantTrip {
        return RestaurantTrip(restaurant.refId, restaurant.name, restaurant.city, noteProvider.getNote(restaurant.refId))
    }
}
