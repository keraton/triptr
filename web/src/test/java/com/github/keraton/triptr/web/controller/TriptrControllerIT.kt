package com.github.keraton.triptr.web.controller

import com.github.keraton.triptr.domain.model.HotelTrip
import com.github.keraton.triptr.domain.model.Trip
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit.jupiter.SpringExtension

import org.assertj.core.api.Assertions.assertThat

@ExtendWith(SpringExtension::class)
@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
internal class TriptrControllerIT {

    @Autowired
    lateinit var restTemplate: TestRestTemplate

    @LocalServerPort
    val port: Int = 0

    @Test
    fun `Should get paris trip`() {
        val (city, hotels) = restTemplate.getForObject("http://localhost:$port/city/Paris", Trip::class.java)
        assertThat(city).isEqualTo("Paris")
        assertThat<HotelTrip>(hotels).hasSize(3)

    }

}