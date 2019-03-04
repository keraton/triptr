package com.github.keraton.triptr.hotel.mapper;

import com.github.keraton.triptr.hotel.model.Hotel;
import com.github.keraton.triptr.domain.model.HotelTrip;
import com.github.keraton.triptr.note.api.NoteProvider;
import org.springframework.stereotype.Component;

@Component
public class HotelMapper {

    private final NoteProvider noteProvider;

    public HotelMapper(NoteProvider noteProvider) {
        this.noteProvider = noteProvider;
    }

    public HotelTrip map(Hotel hotel) {
        return new HotelTrip(hotel.getRefId(), hotel.getName(), hotel.getCity(), noteProvider.getNote(hotel.getRefId()));
    }
}
