package com.github.keraton.triptr.hotel.model;

import lombok.Data;

public @Data class Hotel {

    private final String refId;
    private final String name;
    private final String city;
    private final Integer stars;

}
