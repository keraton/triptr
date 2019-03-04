package com.github.keraton.triptr.hotel.client

import com.github.keraton.triptr.hotel.client.HotelConstant.HILTON
import com.github.keraton.triptr.hotel.model.Hotel
import org.springframework.stereotype.Repository

import java.util.Arrays.asList

@Repository
class HotelProviderClient {

    fun find(city: String): List<Hotel> {
        return asList(
                Hotel("H001", HILTON, city, 5),
                Hotel("H002", "Novotel", city, 3),
                Hotel("H003", "Ibis", city, 2)
        )
    }
}
