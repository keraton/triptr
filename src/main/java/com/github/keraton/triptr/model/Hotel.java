package com.github.keraton.triptr.model;

import lombok.Data;

public @Data class Hotel {

    private final String refId;
    private final String name;
    private final String city;
    private final Integer stars;

}
