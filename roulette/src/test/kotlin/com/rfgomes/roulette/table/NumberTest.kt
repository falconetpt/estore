package com.rfgomes.roulette.table

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class NumberTest {

    @Test
    fun numberZeroIsGreenColor() {
        val number = Number(0)
        assertEquals(Color.Green, number.color)
    }

    @Test
    fun oddNumberIsRedColor() {
        val number = Number(13)
        assertEquals(Color.Red, number.color)
    }

    @Test
    fun evenNumberIsBlackColor() {
        val number = Number(32)
        assertEquals(Color.Black, number.color)
    }
}