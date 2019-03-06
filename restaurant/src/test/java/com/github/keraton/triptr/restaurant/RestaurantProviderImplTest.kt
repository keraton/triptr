package com.github.keraton.triptr.restaurant

import com.github.keraton.triptr.domain.model.NoteCategoryTrip
import com.github.keraton.triptr.domain.model.NoteTrip
import com.github.keraton.triptr.domain.model.RestaurantTrip
import com.github.keraton.triptr.restaurant.client.RestaurantProviderClient
import com.github.keraton.triptr.restaurant.mapper.RestaurantMapper
import com.github.keraton.triptr.restaurant.model.Restaurant
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.BDDMockito
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Spy
import org.mockito.junit.jupiter.MockitoExtension

import java.util.Arrays

import com.github.keraton.triptr.domain.model.NoteCategoryTrip.ACCEPTABLE
import com.github.keraton.triptr.domain.model.NoteCategoryTrip.GOOD
import java.util.Arrays.asList
import org.assertj.core.api.Assertions.assertThat
import org.mockito.ArgumentMatchers.any
import org.mockito.BDDMockito.given

@ExtendWith(MockitoExtension::class)
internal class RestaurantProviderImplTest {

    @InjectMocks
    lateinit var restaurantProvider: RestaurantProviderImpl

    @Mock
    lateinit var restaurantProviderClient: RestaurantProviderClient

    @Mock
    lateinit var restaurantMapper: RestaurantMapper

    @Test
    fun should_get_restaurant_in_Paris() {
        // Given
        given(restaurantProviderClient!!.find("Paris")).willReturn(
                asList(
                        Restaurant("001", "Mc Do", "Paris")
                )
        )

        given(restaurantMapper!!.map(Restaurant("001", "Mc Do", "Paris"))).willReturn(
                RestaurantTrip("001", "Mc Do", "Paris", NoteTrip(1, ACCEPTABLE))
        )

        // When
        val restaurantParis = restaurantProvider!!.find("Paris")

        // Then
        assertThat(restaurantParis).containsExactly(RestaurantTrip("001", "Mc Do", "Paris", NoteTrip(1, ACCEPTABLE)))
    }

}