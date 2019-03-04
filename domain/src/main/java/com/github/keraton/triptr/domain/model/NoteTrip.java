package com.github.keraton.triptr.domain.model;


import lombok.Value;

public @Value class NoteTrip {

    private final Integer stars;
    private final NoteCategoryTrip category;
}
