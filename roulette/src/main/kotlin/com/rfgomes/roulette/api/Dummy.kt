package com.rfgomes.roulette.api

import com.rfgomes.roulette.statistics.StatisticStream
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.messaging.MessageHeaders
import org.springframework.messaging.support.MessageBuilder
import org.springframework.util.MimeTypeUtils
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class Dummy (@Autowired val statisticStream: StatisticStream) {
    @GetMapping
    fun msgTest() {
        val outputStream = statisticStream.outboundGreetings()
        val msg = MessageBuilder.withPayload("Pudim ${UUID.randomUUID()}")
                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
                .build()

        outputStream.send(msg)
    }
}