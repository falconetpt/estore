package com.rfgomes.roulette.statistics

import org.springframework.cloud.stream.annotation.Output
import org.springframework.messaging.MessageChannel


interface StatisticStream {
    @Output("gameStats-out")
    fun outboundGreetings(): MessageChannel
}