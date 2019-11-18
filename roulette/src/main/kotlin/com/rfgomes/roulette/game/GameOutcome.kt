package com.rfgomes.roulette.game

import java.util.*

class GameOutcome (
        val correlationId: String = UUID.randomUUID().toString(),
        val userId: String,
        val game: String = "roulette",
        val betInfo: Map<String, String>,
        val win: Int
)
