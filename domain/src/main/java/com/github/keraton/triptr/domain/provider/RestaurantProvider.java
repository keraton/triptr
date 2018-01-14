package com.github.keraton.triptr.domain.provider;

import com.github.keraton.triptr.domain.model.RestaurantTrip;

import java.util.List;

public interface RestaurantProvider {
    List<RestaurantTrip> find(String city);
}
