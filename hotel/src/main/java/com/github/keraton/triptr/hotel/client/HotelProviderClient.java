package com.github.keraton.triptr.hotel.client;

import com.github.keraton.triptr.domain.model.Stars;
import com.github.keraton.triptr.hotel.model.Hotel;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.github.keraton.triptr.domain.model.Stars.FIVE_STAR;
import static com.github.keraton.triptr.domain.model.Stars.THREE_STAR;
import static com.github.keraton.triptr.domain.model.Stars.TWO_STAR;
import static java.util.Arrays.asList;

@Repository
public class HotelProviderClient {

    private static final String HILTON = "Hilton";
    private static final String NOVOTEL = "Novotel";
    private static final String IBIS = "Ibis";

    public List<Hotel> find(String city) {
        return asList(
                new Hotel("H001", HILTON, city, FIVE_STAR),
                new Hotel("H002", NOVOTEL, city, THREE_STAR),
                new Hotel("H003", IBIS, city, TWO_STAR)
        );
    }
}
