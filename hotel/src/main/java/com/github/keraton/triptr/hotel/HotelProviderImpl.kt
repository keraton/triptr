package com.github.keraton.triptr.hotel

import com.github.keraton.triptr.domain.model.HotelTrip
import com.github.keraton.triptr.hotel.api.HotelProvider
import com.github.keraton.triptr.hotel.client.HotelProviderClient
import com.github.keraton.triptr.hotel.mapper.HotelMapper
import org.springframework.stereotype.Component

@Component
class HotelProviderImpl(private val hotelProviderClient: HotelProviderClient,
                        private val hotelMapper: HotelMapper) : HotelProvider {

    override fun find(city: String): List<HotelTrip> {
        val hotels = hotelProviderClient.find(city)
        return hotels
                .map { hotelMapper.map(it) }
    }
}
