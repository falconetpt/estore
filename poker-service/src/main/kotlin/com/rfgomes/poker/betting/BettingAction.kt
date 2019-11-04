package com.rfgomes.poker.betting

interface BettingAction {

}


/**
 * Enum that represents all betting actions that can be done.
 */
enum class BettingOption {
    /**
     * Make the first wager on the current betting round (if no bet has been made before us).
     */
    Bet,
    /**
     * Exactly match any wager on the current betting round (implies a bet has already been made before us).
     */
    Call,
    /**
     *  Increase the size of the wager on the current betting round (implies a bet or a raise has already
     *  been made before us).
     */
    Raise,
    /**
     * Make no wager and continue with the hand. (Only allowed if there is no bet or raise before us
     * on the current betting round).
     */
    Check,
    /**
     * Discard our holding rather than match the existing wager on the current betting round. By folding
     * we forfeit all right to winning the pot.
     */
    Fold
}