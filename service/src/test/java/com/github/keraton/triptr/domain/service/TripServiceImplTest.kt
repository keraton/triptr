package com.github.keraton.triptr.domain.service


import com.github.keraton.triptr.domain.model.HotelTrip
import com.github.keraton.triptr.domain.model.NoteCategoryTrip.ACCEPTABLE
import com.github.keraton.triptr.domain.model.NoteCategoryTrip.EXCEPTIONAL
import com.github.keraton.triptr.domain.model.NoteTrip
import com.github.keraton.triptr.domain.model.RestaurantTrip
import com.github.keraton.triptr.hotel.api.HotelProvider
import com.github.keraton.triptr.restaurant.api.RestaurantProvider
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.BDDMockito.given
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension
import java.util.Arrays.asList

@ExtendWith(MockitoExtension::class)
internal class TripServiceImplTest {

    @InjectMocks
    lateinit var tripService: TripServiceImpl

    @Mock
    lateinit var hotelProvider: HotelProvider

    @Mock
    lateinit var restaurantProvider: RestaurantProvider

    @Test
    fun `should get paris trip`() {
        // Given
        given(hotelProvider.find("Paris")).willReturn(
                asList(HotelTrip("001", "Hilton", "Paris", NoteTrip(5, EXCEPTIONAL))))
        given(restaurantProvider.find("Paris")).willReturn(
                asList(RestaurantTrip("00A", "Le Cinque", "Paris", NoteTrip(2, ACCEPTABLE)))
        )

        // When
        val (city, hotels, restaurants) = tripService.trip("Paris")

        // Then
        assertThat(city).isEqualTo("Paris")
        assertThat(hotels).containsExactly(HotelTrip("001", "Hilton", "Paris", NoteTrip(5, EXCEPTIONAL)))
        assertThat(restaurants).containsExactly(RestaurantTrip("00A", "Le Cinque", "Paris", NoteTrip(2, ACCEPTABLE)))
    }

}