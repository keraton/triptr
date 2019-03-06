package com.github.keraton.triptr.restaurant

import com.github.keraton.triptr.domain.model.RestaurantTrip
import com.github.keraton.triptr.restaurant.api.RestaurantProvider
import com.github.keraton.triptr.restaurant.client.RestaurantProviderClient
import com.github.keraton.triptr.restaurant.mapper.RestaurantMapper
import com.github.keraton.triptr.restaurant.model.Restaurant
import org.springframework.stereotype.Component

import java.util.stream.Collectors.toList

@Component
class RestaurantProviderImpl(private val restaurantProviderClient: RestaurantProviderClient,
                             private val restaurantMapper: RestaurantMapper) : RestaurantProvider {

    override fun find(city: String): List<RestaurantTrip> {
        val restaurants = restaurantProviderClient.find(city)
        return restaurants
                .map{ restaurantMapper.map(it) }
    }
}
