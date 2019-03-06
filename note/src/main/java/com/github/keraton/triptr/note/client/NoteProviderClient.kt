package com.github.keraton.triptr.note.client

import com.github.keraton.triptr.note.model.Note
import org.springframework.stereotype.Repository

import java.util.HashMap

@Repository
class NoteProviderClient {

    private val noteMap = HashMap<String, Note>()

    init {
        // Hotel
        noteMap["H001"] = Note(5)
        noteMap["H002"] = Note(4)
        noteMap["H003"] = Note(3)

        // Restaurant
        noteMap["R001"] = Note(3)
        noteMap["R002"] = Note(3)
        noteMap["R003"] = Note(3)
    }

    fun getNote(refId: String): Note {
        return noteMap[refId] ?: Note(1)
    }
}
