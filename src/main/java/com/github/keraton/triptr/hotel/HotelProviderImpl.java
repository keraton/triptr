package com.github.keraton.triptr.hotel;

import com.github.keraton.triptr.domain.provider.HotelProvider;
import com.github.keraton.triptr.hotel.client.HotelProviderClient;
import com.github.keraton.triptr.hotel.model.Hotel;
import com.github.keraton.triptr.domain.model.HotelTrip;
import com.github.keraton.triptr.note.NoteProvider;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
public class HotelProviderImpl implements HotelProvider {

    private final HotelProviderClient hotelProviderClient;
    private final NoteProvider noteProvider;


    public HotelProviderImpl(HotelProviderClient hotelProviderClient,
                             NoteProvider noteProvider) {
        this.hotelProviderClient = hotelProviderClient;
        this.noteProvider = noteProvider;
    }

    @Override
    public List<HotelTrip> find(String city) {
        List<Hotel> hotels = hotelProviderClient.find(city);
        return hotels.stream()
                .map(HotelTrip::convert)
                .map(hotelTrip -> {
                    hotelTrip.setNote(noteProvider.getNote(hotelTrip.getRefId()));
                    return hotelTrip;
                })
                .collect(toList());
    }
}
