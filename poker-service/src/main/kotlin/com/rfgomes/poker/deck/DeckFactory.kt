package com.rfgomes.poker.deck

import com.rfgomes.poker.card.Card
import com.rfgomes.poker.card.CardSuit
import com.rfgomes.poker.card.CardValue
import org.springframework.stereotype.Component
import java.util.*
import kotlin.collections.ArrayList

/**
 * Component Responsible for creating decks out of the card set.
 */
@Component
class DeckFactory {
    private var cardSet = init()

    /**
     * Method responsible for returning a shuffled Deck Object.
     */
    fun getShuffledDeck() : Deck {
        return Deck(cards = ArrayDeque(cardSet.shuffled()))
    }

    private fun init() : List<Card> {
        val cardSuits = CardSuit.values()
        val cardValues = CardValue.values()
        val listCards = ArrayList<Card>()

        cardSuits.forEach { suit ->
            cardValues.forEach {
                value -> listCards.add(Card(value, suit))
            }
        }

        return listCards
    }
}
