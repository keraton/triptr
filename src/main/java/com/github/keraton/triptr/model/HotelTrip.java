package com.github.keraton.triptr.model;

import com.github.keraton.triptr.mapper.HotelMapper;
import lombok.Data;

public @Data class HotelTrip {

    private final String refId;
    private final String name;
    private final String city;
    private NoteTrip note;

    public static HotelTrip convert(Hotel hotel) {
        return HotelMapper.map(hotel);
    }

}
