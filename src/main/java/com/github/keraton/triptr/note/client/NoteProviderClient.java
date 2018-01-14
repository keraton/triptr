package com.github.keraton.triptr.note.client;

import com.github.keraton.triptr.note.model.Note;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class NoteProviderClient {

    private Map<String, Note> noteMap = new HashMap<>();

    public NoteProviderClient() {
        // Hotel
        noteMap.put("H001", new Note(5));
        noteMap.put("H002", new Note(4));
        noteMap.put("H003", new Note(3));

        // Restaurant
        noteMap.put("R001", new Note(3));
        noteMap.put("R002", new Note(3));
        noteMap.put("R003", new Note(3));
    }

    public Note getNote(String refId) {
        return noteMap.get(refId);
    }
}
