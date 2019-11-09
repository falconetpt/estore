package com.rfgomes.roulette

import com.rfgomes.roulette.table.Color
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.stream.annotation.EnableBinding

@SpringBootApplication
class RouletteApplication

fun main(args: Array<String>) {
    runApplication<RouletteApplication>(*args)
}
