package com.rfgomes.roulette.bet

import com.rfgomes.roulette.bet.action.StraightAction
import com.rfgomes.roulette.table.Number

interface BettingAction {
    fun evaluate(bet: Number, result: Number): Boolean
}

enum class BetType(val bettingAction: BettingAction) {
    Straight(StraightAction()),
}


