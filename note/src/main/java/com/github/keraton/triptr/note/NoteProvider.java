package com.github.keraton.triptr.note;

import com.github.keraton.triptr.note.client.NoteProviderClient;
import com.github.keraton.triptr.note.model.Note;
import com.github.keraton.triptr.domain.model.NoteCategoryTrip;
import com.github.keraton.triptr.domain.model.NoteTrip;
import com.github.keraton.triptr.note.util.NoteUtils;
import org.springframework.stereotype.Component;

@Component
public class NoteProvider {

    private final NoteProviderClient noteProviderClient;
    private final NoteUtils noteUtils;

    public NoteProvider(NoteProviderClient noteProviderClient, NoteUtils noteUtils) {
        this.noteProviderClient = noteProviderClient;
        this.noteUtils = noteUtils;
    }

    public NoteTrip getNote(String refId) {
        Note note = noteProviderClient.getNote(refId);
        NoteCategoryTrip noteCategoryTrip = null;
        if (refId.startsWith("H")) {
            noteCategoryTrip = noteUtils.calculateHotelNote(note.getStars());
        }
        else if (refId.startsWith("R")) {
            noteCategoryTrip = noteUtils.calculateRestaurantNote(note.getStars());
        }
        return new NoteTrip(note.getStars(), noteCategoryTrip);
    }
}
