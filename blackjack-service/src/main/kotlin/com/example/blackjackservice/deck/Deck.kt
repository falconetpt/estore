package com.rfgomes.poker.deck

import com.rfgomes.poker.card.Card
import java.util.*

class Deck(val id: String = UUID.randomUUID().toString(), private val cards: Deque<Card>) {
    fun pullCard() : Card {
        return cards.pop()
    }
}
