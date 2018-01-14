package com.github.keraton.triptr.note.util;

import com.github.keraton.triptr.domain.model.NoteCategoryTrip;
import org.springframework.stereotype.Component;

import static com.github.keraton.triptr.domain.model.NoteCategoryTrip.*;

@Component
public class NoteUtils {

    public NoteCategoryTrip calculateHotelNote(Integer stars) {
        switch (stars) {
            case 5:
                return EXCEPTIONAL;
            case 4:
                return GOOD;
            case 3:
                return ACCEPTABLE;
            case 2:
                return ACCEPTABLE;
            default:
                return BAD;
        }
    }

    public NoteCategoryTrip calculateRestaurantNote(Integer stars) {
        switch (stars) {
            case 3:
                return EXCEPTIONAL;
            case 2:
                return GOOD;
            case 1:
                return GOOD;
            default:
                return BAD;
        }
    }
}
