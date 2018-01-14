package com.github.keraton.triptr.domain.provider;

import com.github.keraton.triptr.domain.model.HotelTrip;

import java.util.List;

public interface HotelProvider {
    List<HotelTrip> find(String city);
}
