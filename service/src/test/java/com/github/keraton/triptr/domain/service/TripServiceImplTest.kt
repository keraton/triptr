package com.github.keraton.triptr.domain.service


import com.github.keraton.triptr.domain.model.HotelTrip
import com.github.keraton.triptr.domain.model.NoteTrip
import com.github.keraton.triptr.domain.model.RestaurantTrip
import com.github.keraton.triptr.domain.model.Trip
import com.github.keraton.triptr.hotel.api.HotelProvider
import com.github.keraton.triptr.restaurant.api.RestaurantProvider
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension

import com.github.keraton.triptr.domain.model.NoteCategoryTrip.ACCEPTABLE
import com.github.keraton.triptr.domain.model.NoteCategoryTrip.EXCEPTIONAL
import java.util.Arrays.asList
import org.assertj.core.api.Assertions.assertThat
import org.mockito.BDDMockito.given

@ExtendWith(MockitoExtension::class)
internal class TripServiceImplTest {

    @InjectMocks
    lateinit var tripService: TripServiceImpl

    @Mock
    lateinit var hotelProvider: HotelProvider

    @Mock
    lateinit var restaurantProvider: RestaurantProvider

    @Test
    fun `Should get paris trip ☺️`() {
        // Given
        given(hotelProvider.find("Paris")).willReturn(
                asList(HotelTrip("001", "Hilton", "Paris", NoteTrip(5, EXCEPTIONAL)))
        )

        given(restaurantProvider.find("Paris")).willReturn(
                asList(RestaurantTrip("001", "Mc Do", "Paris", NoteTrip(1, ACCEPTABLE)))
        )

        // When
        val (city, hotels, restaurants) = tripService.trip("Paris")

        // Then
        assertThat(city).isEqualTo("Paris")
        assertThat(hotels).containsExactly(HotelTrip("001", "Hilton", "Paris", NoteTrip(5, EXCEPTIONAL)))
        assertThat(restaurants).containsExactly(RestaurantTrip("001", "Mc Do", "Paris", NoteTrip(1, ACCEPTABLE)))
    }

}