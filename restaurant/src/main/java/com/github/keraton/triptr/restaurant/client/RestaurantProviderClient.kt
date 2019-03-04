package com.github.keraton.triptr.restaurant.client

import com.github.keraton.triptr.restaurant.model.Restaurant
import org.springframework.stereotype.Repository

import java.util.Arrays.asList

@Repository
class RestaurantProviderClient {
    fun find(city: String): List<Restaurant> {
        return asList(
                Restaurant("R001", "Fouquet's", city),
                Restaurant("R002", "La Rotonde", city),
                Restaurant("R003", "Le Cinq", city)
        )
    }
}
