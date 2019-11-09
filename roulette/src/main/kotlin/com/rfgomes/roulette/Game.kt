package com.rfgomes.roulette

import com.rfgomes.roulette.bet.BetInfo
import com.rfgomes.roulette.bet.action.BetType
import com.rfgomes.roulette.table.Number
import com.rfgomes.roulette.table.NumberPool
import org.springframework.beans.factory.annotation.Autowired

class Game (@Autowired val numberPool: NumberPool, val list: List<Int>, val betType: BetType) {
    fun calculateOutcome() {
        val winner = numberPool.obtainNumbers().random()
        val betInfo = BetInfo(list.map { Number(it) }, winner)

        betType.bettingAction.evaluate(betInfo)
    }
}