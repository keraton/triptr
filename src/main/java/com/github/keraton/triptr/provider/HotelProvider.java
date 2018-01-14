package com.github.keraton.triptr.provider;

import com.github.keraton.triptr.client.HotelProviderClient;
import com.github.keraton.triptr.model.Hotel;
import com.github.keraton.triptr.model.HotelTrip;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
public class HotelProvider {

    private final HotelProviderClient hotelProviderClient;
    private final NoteProvider noteProvider;


    public HotelProvider(HotelProviderClient hotelProviderClient,
                         NoteProvider noteProvider) {
        this.hotelProviderClient = hotelProviderClient;
        this.noteProvider = noteProvider;
    }

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
