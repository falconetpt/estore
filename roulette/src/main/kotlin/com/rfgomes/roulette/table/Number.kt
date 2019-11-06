package com.rfgomes.roulette.table

import java.util.function.Predicate

class Number(val value: Int) {
    val color = Color.values().first { it.predicate.test(value) }
}

private val isValueZero = Predicate<Int> { it == 0 }
private val isDivisibleByTwo = Predicate<Int> { it % 2 == 0 }

enum class Color(val predicate: Predicate<Int>) {
    Green(Predicate { isValueZero.test(it) }),
    Red(Predicate { isDivisibleByTwo.test(it).not() && isValueZero.test(it).not() }),
    Black(Predicate { isDivisibleByTwo.test(it) && isValueZero.test(it).not() })
}
