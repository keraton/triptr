package com.github.keraton.triptr.domain.model

/**
 * Trip main class
 */
data class Trip (
    val city: String,
    val hotels: List<HotelTrip>,
    val restaurants: List<RestaurantTrip>
)

data class HotelTrip (
    val refId: String,
    val name: String,
    val city: String,
    val note: NoteTrip
)

data class NoteTrip (
    val stars: Int,
    val category: NoteCategoryTrip
)

data class RestaurantTrip (
    val refId: String,
    val name: String,
    val city: String,
    val note: NoteTrip
)

enum class NoteCategoryTrip {
    EXCEPTIONAL, GOOD, ACCEPTABLE, BAD
}


