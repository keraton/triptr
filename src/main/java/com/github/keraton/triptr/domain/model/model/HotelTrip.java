package com.github.keraton.triptr.domain.model.model;

import com.github.keraton.triptr.hotel.mapper.HotelMapper;
import com.github.keraton.triptr.hotel.model.Hotel;
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
