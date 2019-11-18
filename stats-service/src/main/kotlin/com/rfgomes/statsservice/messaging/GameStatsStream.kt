package com.rfgomes.statsservice.messaging

import org.springframework.messaging.SubscribableChannel
import org.springframework.cloud.stream.annotation.Input;



interface GameStatsStream {
    @Input("gameStats-in")
    fun inbound(): SubscribableChannel
}