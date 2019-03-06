package com.github.keraton.triptr.restaurant.client

import com.github.keraton.triptr.restaurant.model.Restaurant
import org.springframework.stereotype.Repository

import java.util.Arrays.asList

@Repository
class RestaurantProviderClient {

    fun find(city: String): List<Restaurant> {
        return asList(
                Restaurant("R001", FOUQUET_S, city),
                Restaurant("R002", LA_ROTONDE, city),
                Restaurant("R003", LE_CINQ, city)
        )
    }

    companion object {

        private val FOUQUET_S = "Fouquet's"
        private val LA_ROTONDE = "La Rotonde"
        private val LE_CINQ = "Le Cinq"
    }
}
