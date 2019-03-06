package com.github.keraton.triptr.hotel.client


import com.github.keraton.triptr.domain.model.Stars
import com.github.keraton.triptr.domain.model.Stars.FIVE_STAR
import com.github.keraton.triptr.domain.model.Stars.THREE_STAR
import com.github.keraton.triptr.domain.model.Stars.TWO_STAR
import com.github.keraton.triptr.hotel.model.Hotel
import org.springframework.stereotype.Repository

import java.util.Arrays.asList

@Repository
class HotelProviderClient {

    fun find(city: String): List<Hotel> {
        return asList(
                Hotel("H001", HILTON, city, FIVE_STAR),
                Hotel("H002", NOVOTEL, city, THREE_STAR),
                Hotel("H003", IBIS, city, TWO_STAR)
        )
    }

    companion object {
        private val HILTON = "Hilton"
        private val NOVOTEL = "Novotel"
        private val IBIS = "Ibis"
    }
}
