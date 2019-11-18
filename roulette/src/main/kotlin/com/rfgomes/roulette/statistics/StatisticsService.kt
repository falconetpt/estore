package com.rfgomes.roulette.statistics

import com.rfgomes.roulette.game.GameOutcome
import com.rfgomes.roulette.statistics.messaging.StatisticStream
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.messaging.MessageHeaders
import org.springframework.messaging.support.MessageBuilder
import org.springframework.stereotype.Service
import org.springframework.util.MimeTypeUtils
import java.util.*

@Service
class StatisticsService (@Autowired val statisticStream: StatisticStream) {
    fun reportGameResult() {
        val outputStream = statisticStream.outboundStatistics()

        val payload = GameOutcome(
                userId = UUID.randomUUID().toString(),
                betInfo = mapOf(Pair("BetType", "Value")),
                win = 1
        )

        val msg = MessageBuilder.withPayload(payload)
                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
                .build()

        outputStream.send(msg)
    }
}
