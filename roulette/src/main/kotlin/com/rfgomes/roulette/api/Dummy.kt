package com.rfgomes.roulette.api

import com.rfgomes.roulette.statistics.StatisticsService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class Dummy (@Autowired val statisticsService: StatisticsService) {
    @GetMapping
    fun msgTest() {
        statisticsService.reportGameResult();
    }
}