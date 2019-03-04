package com.github.keraton.triptr.hotel.client

import com.github.keraton.triptr.hotel.model.Hotel

import java.util.Arrays.asList

class HotelProviderClientV2 {

    // Static constant
    companion object {
        private val HILTON = "Hilton"
        private val NOVOTEL = "Novotel"
        private val IBIS = "Ibis"
    }

    fun find(city: String): List<Hotel> {
        return asList(
                Hotel("H001", HILTON, city, 5),
                Hotel("H002", NOVOTEL, city, 3),
                Hotel("H003", IBIS, city, 2)
        )
    }
}
