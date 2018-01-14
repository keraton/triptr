package com.github.keraton.triptr.mapper;

import com.github.keraton.triptr.model.Hotel;
import com.github.keraton.triptr.model.HotelTrip;
import org.springframework.stereotype.Component;

@Component
public class HotelMapper {

    public static HotelTrip map(Hotel hotel) {
        return new HotelTrip(hotel.getRefId(), hotel.getName(), hotel.getCity());
    }
}
