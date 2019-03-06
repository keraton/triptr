package com.github.keraton.triptr.hotel

import com.github.keraton.triptr.hotel.api.HotelProvider
import com.github.keraton.triptr.hotel.client.HotelProviderClient
import com.github.keraton.triptr.hotel.mapper.HotelMapper
import com.github.keraton.triptr.hotel.model.Hotel
import com.github.keraton.triptr.domain.model.HotelTrip
import com.github.keraton.triptr.note.api.NoteProvider
import org.springframework.stereotype.Component

import java.util.stream.Collectors.toList

@Component
class HotelProviderImpl(private val hotelProviderClient: HotelProviderClient,
                        private val hotelMapper: HotelMapper) : HotelProvider {

    override fun find(city: String): List<HotelTrip> {
        val hotels = hotelProviderClient.find(city)
        return hotels
                .map{ hotelMapper.map(it) }
    }
}
