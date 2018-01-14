package com.github.keraton.triptr.hotel.client;

import com.github.keraton.triptr.hotel.model.Hotel;
import org.springframework.stereotype.Repository;

import java.util.List;

import static java.util.Arrays.asList;

@Repository
public class HotelProviderClient {

    public List<Hotel> find(String city) {
        return asList(
                new Hotel("H001", "Hilton", city, 5),
                new Hotel("H002", "Novotel", city, 3),
                new Hotel("H003", "Ibis", city, 2)
        );
    }
}
