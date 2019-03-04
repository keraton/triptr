package com.github.keraton.triptr.domain.service;

import com.github.keraton.triptr.domain.model.HotelTrip;
import com.github.keraton.triptr.domain.model.NoteTrip;
import com.github.keraton.triptr.domain.model.RestaurantTrip;
import com.github.keraton.triptr.domain.model.Trip;
import com.github.keraton.triptr.hotel.api.HotelProvider;
import com.github.keraton.triptr.restaurant.api.RestaurantProvider;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.github.keraton.triptr.domain.model.NoteCategoryTrip.ACCEPTABLE;
import static com.github.keraton.triptr.domain.model.NoteCategoryTrip.EXCEPTIONAL;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class TripServiceImplTest {

    @InjectMocks
    private TripServiceImpl tripService;

    @Mock
    private HotelProvider hotelProvider;

    @Mock
    private RestaurantProvider restaurantProvider;

    @Test
    void should_get_paris_trip () {
        // Given
        given(hotelProvider.find("Paris")).willReturn(
                asList(new HotelTrip("001", "Hilton", "Paris", new NoteTrip(5, EXCEPTIONAL)))
        );

        given(restaurantProvider.find("Paris")).willReturn(
                asList(new RestaurantTrip("001", "Mc Do", "Paris", new NoteTrip(1, ACCEPTABLE)))
        );

        // When
        Trip tripParis = tripService.trip("Paris");

        // Then
        assertThat(tripParis.getCity()).isEqualTo("Paris");
        assertThat(tripParis.getHotels()).containsExactly(new HotelTrip("001", "Hilton", "Paris", new NoteTrip(5, EXCEPTIONAL)));
        assertThat(tripParis.getRestaurants()).containsExactly(new RestaurantTrip("001", "Mc Do", "Paris", new NoteTrip(1, ACCEPTABLE)));
    }

}