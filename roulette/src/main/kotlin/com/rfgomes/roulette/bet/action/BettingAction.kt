package com.rfgomes.roulette.bet.action

import com.rfgomes.roulette.bet.BetInfo

interface BettingAction {
    fun evaluate(bet: BetInfo): Boolean
}

enum class BetType(val bettingAction: BettingAction) {
    STRAIGHT(Straight()),
    SPLIT(Split()),
    STREET(Street()),
    SIX_LINE(SixLine()),
    CORNER(Corner()),
    TRIO(Trio()),
    BASKET(Basket()),
    RED(Red())
}


