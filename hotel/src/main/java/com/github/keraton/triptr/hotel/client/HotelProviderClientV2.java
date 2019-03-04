package com.github.keraton.triptr.hotel.client;

import com.github.keraton.triptr.hotel.model.Hotel;

import java.util.List;

import static java.util.Arrays.asList;

public class HotelProviderClientV2 {

    private static final String HILTON = "Hilton";
    private static final String NOVOTEL = "Novotel";
    private static final String IBIS = "Ibis";

    public List<Hotel> find(String city) {
        return asList(
                new Hotel("H001", HILTON, city, 5),
                new Hotel("H002", NOVOTEL, city, 3),
                new Hotel("H003", IBIS, city, 2)
        );
    }
}
