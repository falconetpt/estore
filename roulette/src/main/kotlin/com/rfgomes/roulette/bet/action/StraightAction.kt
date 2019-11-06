package com.rfgomes.roulette.bet.action

import com.rfgomes.roulette.bet.BettingAction
import com.rfgomes.roulette.table.Number

class StraightAction : BettingAction {
    override fun evaluate(bet: Number, result: Number): Boolean {
        return bet == result
    }
}

class SplitAction : BettingAction {
    override fun evaluate(bet: Number, result: Number): Boolean {
        val possibilities = ArrayList<Int>()
    }
}

class BasketAction : BettingAction {
    override fun evaluate(bet: Number, result: Number): Boolean {
        val possibilities = listOf(0, 1, 2, 3)

        return possibilities.contains(bet.value)
                && possibilities.contains(result.value)
    }
}