package com.github.keraton.triptr.hotel.mapper

import com.github.keraton.triptr.domain.model.HotelTrip
import com.github.keraton.triptr.hotel.model.Hotel
import com.github.keraton.triptr.note.api.NoteProvider
import org.springframework.stereotype.Component

@Component
class HotelMapper(private val noteProvider: NoteProvider) {

    fun map(hotel: Hotel): HotelTrip {
        return HotelTrip(hotel.refId, hotel.name, hotel.city, noteProvider.getNote(hotel.refId))
    }
}
