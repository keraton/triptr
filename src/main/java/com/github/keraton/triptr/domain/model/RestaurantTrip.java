package com.github.keraton.triptr.domain.model;

import lombok.Data;

public @Data class RestaurantTrip {

    private final String refId;
    private final String name;
    private final String city;
    private NoteTrip note;


}
