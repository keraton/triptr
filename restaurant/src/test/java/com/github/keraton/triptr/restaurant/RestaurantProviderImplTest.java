package com.github.keraton.triptr.restaurant;

import com.github.keraton.triptr.domain.model.NoteCategoryTrip;
import com.github.keraton.triptr.domain.model.NoteTrip;
import com.github.keraton.triptr.domain.model.RestaurantTrip;
import com.github.keraton.triptr.restaurant.client.RestaurantProviderClient;
import com.github.keraton.triptr.restaurant.mapper.RestaurantMapper;
import com.github.keraton.triptr.restaurant.model.Restaurant;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static com.github.keraton.triptr.domain.model.NoteCategoryTrip.ACCEPTABLE;
import static com.github.keraton.triptr.domain.model.NoteCategoryTrip.GOOD;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class RestaurantProviderImplTest {

    @InjectMocks
    private RestaurantProviderImpl restaurantProvider;

    @Mock
    private RestaurantProviderClient restaurantProviderClient;

    @Mock
    private RestaurantMapper restaurantMapper;

    @Test
    void should_get_restaurant_in_Paris () {
        // Given
        given(restaurantProviderClient.find("Paris")).willReturn(
                asList(
                        new Restaurant("001", "Mc Do", "Paris")
                )
        );

        given(restaurantMapper.map(new Restaurant("001", "Mc Do", "Paris"))).willReturn(
                new RestaurantTrip("001", "Mc Do", "Paris", new NoteTrip(1, ACCEPTABLE))
        );

        // When
        List<RestaurantTrip> restaurantParis = restaurantProvider.find("Paris");

        // Then
        assertThat(restaurantParis).containsExactly(new RestaurantTrip("001", "Mc Do", "Paris", new NoteTrip(1, ACCEPTABLE)));
    }

}