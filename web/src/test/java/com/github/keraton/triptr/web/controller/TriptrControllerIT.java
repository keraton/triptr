package com.github.keraton.triptr.web.controller;

import com.github.keraton.triptr.domain.model.Trip;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
class TriptrControllerIT {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @DisplayName("Should get trip for Paris")
    @Test
    void should () {
        Trip trip = restTemplate.getForObject("http://localhost:" + port + "/city/Paris", Trip.class);
        assertThat(trip.getCity()).isEqualTo("Paris");
        assertThat(trip.getHotels()).hasSize(3);
        assertThat(trip.getRestaurants()).hasSize(3);
    }
}