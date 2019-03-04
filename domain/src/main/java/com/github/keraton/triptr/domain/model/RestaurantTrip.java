package com.github.keraton.triptr.domain.model;

import lombok.Value;

public @Value class RestaurantTrip {

    private final String refId;
    private final String name;
    private final String city;
    private final NoteTrip note;


}
