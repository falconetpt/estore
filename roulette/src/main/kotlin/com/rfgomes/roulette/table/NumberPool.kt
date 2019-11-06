package com.rfgomes.roulette.table

import org.springframework.stereotype.Component

/**
 * Component that contains The Roulette number Pool:
 *  Range [0 - 36]
 */
@Component
class NumberPool {
    private val numbers = (0..36).map { Number(it) }

    /**
     * Obtain a Set that contains the number pool
     */
    fun obtainNumbers() : Set<Number> {
        return numbers.toSet()
    }
}