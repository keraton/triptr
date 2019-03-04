package com.github.keraton.triptr.note.util

import com.github.keraton.triptr.domain.model.NoteCategoryTrip
import com.github.keraton.triptr.domain.model.NoteCategoryTrip.*
import org.springframework.stereotype.Component

@Component
class NoteUtils {

    fun calculateHotelNote(stars: Int?): NoteCategoryTrip {
        when (stars) {
            5 -> return EXCEPTIONAL
            4 -> return GOOD
            3 -> return ACCEPTABLE
            2 -> return ACCEPTABLE
            else -> return BAD
        }
    }

    fun calculateRestaurantNote(stars: Int?): NoteCategoryTrip {
        when (stars) {
            3 -> return EXCEPTIONAL
            2 -> return GOOD
            1 -> return GOOD
            else -> return BAD
        }
    }
}
