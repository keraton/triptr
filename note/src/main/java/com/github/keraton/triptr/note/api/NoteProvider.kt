package com.github.keraton.triptr.note.api

import com.github.keraton.triptr.domain.model.NoteTrip

interface NoteProvider {
    fun getNote(refId: String): NoteTrip
}
