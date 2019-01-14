package com.github.keraton.triptr.note.api;

import com.github.keraton.triptr.domain.model.NoteTrip;

public interface NoteProvider {
    NoteTrip getNote(String refId);
}
