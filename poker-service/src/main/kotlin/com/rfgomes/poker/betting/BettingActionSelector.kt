package com.rfgomes.poker.betting

import com.rfgomes.poker.betting.action.*
import org.springframework.stereotype.Component

@Component
class BettingActionSelector {
    private val bettingActions = mapOf(
            Pair(BettingOption.Bet, Bet()),
            Pair(BettingOption.Call, Call()),
            Pair(BettingOption.Check, Check()),
            Pair(BettingOption.Fold, Fold()),
            Pair(BettingOption.Raise, Raise())
    )

    private val defaultBettingOption = DefaultBettingOption()

    /**
     * TODO - LOG when it is not present
     */
    fun getAction(bettingOption: BettingOption) : BettingAction = bettingActions[bettingOption] ?: defaultBettingOption
}
