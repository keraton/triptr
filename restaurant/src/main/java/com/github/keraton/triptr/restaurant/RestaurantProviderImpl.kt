package com.github.keraton.triptr.restaurant

import com.github.keraton.triptr.domain.model.RestaurantTrip
import com.github.keraton.triptr.restaurant.api.RestaurantProvider
import com.github.keraton.triptr.restaurant.client.RestaurantProviderClient
import com.github.keraton.triptr.restaurant.mapper.RestaurantMapper
import org.springframework.stereotype.Component

@Component
class RestaurantProviderImpl(private val restaurantProviderClient: RestaurantProviderClient,
                             private val restaurantMapper: RestaurantMapper) : RestaurantProvider {

    override fun find(city: String): List<RestaurantTrip> {
        val restaurants = restaurantProviderClient.find(city)
        return restaurants
                .map { restaurantMapper.map(it) }
    }
}
