package com.rfgomes.roulette.bet

import com.rfgomes.roulette.table.Number

class BetInfo (val list: List<Number>, val result: Number) {
    fun isWinner() : Boolean = list.contains(result)
}
