package com.github.keraton.triptr

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class TriptrApplication

fun main(args: Array<String>) {
    runApplication<TriptrApplication>(*args)
}

