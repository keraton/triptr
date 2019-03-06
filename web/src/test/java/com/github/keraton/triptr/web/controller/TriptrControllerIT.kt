package com.github.keraton.triptr.web.controller

import com.github.keraton.triptr.domain.model.HotelTrip
import com.github.keraton.triptr.domain.model.RestaurantTrip
import com.github.keraton.triptr.domain.model.Trip
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.test.context.junit.jupiter.SpringExtension

import org.assertj.core.api.Assertions.assertThat
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT

@ExtendWith(SpringExtension::class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
internal class TriptrControllerIT {

    @LocalServerPort
    private val port: Int = 0

    @Autowired
    private val restTemplate: TestRestTemplate? = null

    @DisplayName("Should get trip for Paris")
    @Test
    fun should() {
        val (city, hotels, restaurants) = restTemplate!!.getForObject("http://localhost:$port/city/Paris", Trip::class.java)
        assertThat(city).isEqualTo("Paris")
        assertThat<HotelTrip>(hotels).hasSize(3)
        assertThat<RestaurantTrip>(restaurants).hasSize(3)
    }
}