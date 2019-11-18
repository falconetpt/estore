package com.rfgomes.roulette.bet.action

import com.rfgomes.roulette.bet.BetInfo
import com.rfgomes.roulette.table.Color
import com.rfgomes.roulette.table.Number
import java.util.function.BiPredicate
import java.util.function.Predicate
import kotlin.math.abs

/**
 * This is a bet that covers only one number. In order to make this bet, place the chip inside the square of the number.
 */
class Straight : BettingAction {
    override fun evaluate(bet: BetInfo): Boolean {
        if(bet.list.size == 1) {
            return bet.isWinner()
        }

        return false
    }
}


/**
 * A bet on two numbers which are adjacent on the table.
 * Made by placing the chip on the shared line of the two numbers’ squares.
 */
class Split : BettingAction {
    private val columnBet = BiPredicate<Int, Int> { x, y -> abs(x - y) == 3 }
    private val sameLine = BiPredicate<Int, Int> { x, y -> (x - 1) / 3 ==  (y - 1) / 3 }
    private val lineBet = BiPredicate<Int, Int> { x, y -> abs(x - y) == 1 && sameLine.test(x, y) }

    override fun evaluate(bet: BetInfo): Boolean {
        if (bet.list.size != 2) {
            return false
        }

        val firstBet = bet.list[0].value
        val secondBet = bet.list[1].value

        return columnBet.or(lineBet).test(firstBet, secondBet) && bet.isWinner()
    }
}


/**
 * A bet on three consecutive numbers located on the same line.
 * Make the bet by placing the chip on the outer corner of the row.
 */
class Street : BettingAction {
    private val sameLine = BiPredicate<Int, Int> { x, y -> (x - 1) / 3 ==  (y - 1) / 3 }
    private val lineBet = BiPredicate<Int, Int> { x, y -> abs(x - y) == 1 && sameLine.test(x, y) }

    override fun evaluate(bet: BetInfo): Boolean {
        if (bet.list.size != 3) {
            return false
        }

        return bet.list.asSequence()
                .map { it.value }
                .zipWithNext()
                .fold(true) { acc, e -> acc && lineBet.test(e.first, e.second) }
                && bet.isWinner()
    }
}


/**
 * A bet on two adjacent lines.
 * In order to make this bet, you have to place the chip on the common outer corner of the two lines.
 */
class SixLine : BettingAction {
    override fun evaluate(bet: BetInfo): Boolean {
        val numbers = bet.list.asSequence().map { it.value }.sorted()
        val range = numbers.max()!! - numbers.min()!! + 1

        if (range != 6) {
            return false
        }

        return bet.isWinner()
    }
}


/**
 * This is a four-number bet, placed by putting the chip on the common corner of the four numbers.
 * Also called ‘square’ bet.
 */
class Corner : BettingAction {
    override fun evaluate(bet: BetInfo): Boolean {
        if (bet.list.size != 4) {
            return false
        }

        return bet.isWinner()
    }

}


/**
 * A three-number bet that includes the zero or zeros.
 * Place the chip on the line shared by the zero box and the two other numbers.
 */
class Trio : BettingAction {
    override fun evaluate(bet: BetInfo): Boolean {
        if (bet.list.any { it.value == 0 }) {
            return bet.list.any { it.value == bet.result.value}
        }

        return false
    }
}


/**
 * Bet on 0, 1, 2 and 3 with a chip on the corner shared by the zero box and the first line.
 * In American Roulette, it includes the double zero.
 */
class Basket : BettingAction {
    private val predicate = Predicate<Number> { (0..3).contains(it.value) }

    override fun evaluate(bet: BetInfo): Boolean {
        return bet.list.any(predicate::test) && bet.isWinner()
    }
}

/**
 * Bet on the colour Red.
 */
class Red : BettingAction {
    private val notRedColor = Predicate<Number> { it.color != Color.Red }
    override fun evaluate(bet: BetInfo): Boolean {
        if (bet.list.any(notRedColor::test)) {
            return false
        }

        return bet.isWinner()
    }
}

/**
 * Bet on the colour Black.
 */
class Black : BettingAction {
    private val notBlackColor = Predicate<Number> { it.color != Color.Black }
    override fun evaluate(bet: BetInfo): Boolean {
        if (bet.list.any(notBlackColor::test)) {
            return false
        }

        return bet.isWinner()
    }
}

/**
 * Bet on Odd Numbers
 */
class Odd : BettingAction {
    private val isNotOddNumber = Predicate<Number> { it.value % 2 == 0 }

    override fun evaluate(bet: BetInfo): Boolean {
        if (bet.list.any(isNotOddNumber::test)) {
            return false
        }

        return bet.isWinner()
    }
}

/**
 * Bet on Even Numbers
 */
class Even : BettingAction {
    private val isNotEvenNumber = Predicate<Number> { it.value % 2 != 0 }

    override fun evaluate(bet: BetInfo): Boolean {
        if (bet.list.any(isNotEvenNumber::test)) {
            return false
        }

        return bet.isWinner()
    }
}
