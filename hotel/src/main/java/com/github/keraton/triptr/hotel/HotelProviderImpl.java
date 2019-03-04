package com.github.keraton.triptr.hotel;

import com.github.keraton.triptr.hotel.api.HotelProvider;
import com.github.keraton.triptr.hotel.client.HotelProviderClient;
import com.github.keraton.triptr.hotel.mapper.HotelMapper;
import com.github.keraton.triptr.hotel.model.Hotel;
import com.github.keraton.triptr.domain.model.HotelTrip;
import com.github.keraton.triptr.note.api.NoteProvider;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
public class HotelProviderImpl implements HotelProvider {

    private final HotelProviderClient hotelProviderClient;
    private final HotelMapper hotelMapper;


    public HotelProviderImpl(HotelProviderClient hotelProviderClient,
                             HotelMapper hotelMapper) {
        this.hotelProviderClient = hotelProviderClient;
        this.hotelMapper = hotelMapper;
    }

    @Override
    public List<HotelTrip> find(String city) {
        List<Hotel> hotels = hotelProviderClient.find(city);
        return hotels.stream()
                .map(hotelMapper::map)
                .collect(toList());
    }
}
