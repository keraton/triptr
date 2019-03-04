package com.github.keraton.triptr.note

import com.github.keraton.triptr.note.api.NoteProvider
import com.github.keraton.triptr.note.client.NoteProviderClient
import com.github.keraton.triptr.note.model.Note
import com.github.keraton.triptr.domain.model.NoteCategoryTrip
import com.github.keraton.triptr.domain.model.NoteTrip
import com.github.keraton.triptr.note.util.NoteUtils
import org.springframework.stereotype.Component

@Component
class NoteProviderImpl(private val noteProviderClient: NoteProviderClient, private val noteUtils: NoteUtils) : NoteProvider {

    override fun getNote(refId: String): NoteTrip {
        val (stars) = noteProviderClient.getNote(refId)
        var noteCategoryTrip: NoteCategoryTrip? = null
        if (refId.startsWith("H")) {
            noteCategoryTrip = noteUtils.calculateHotelNote(stars)
        } else if (refId.startsWith("R")) {
            noteCategoryTrip = noteUtils.calculateRestaurantNote(stars)
        }
        return NoteTrip(stars, noteCategoryTrip!!)
    }
}
