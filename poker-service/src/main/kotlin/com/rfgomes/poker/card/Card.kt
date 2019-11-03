package com.rfgomes.poker.card

class Card(cardValue: CardValue, cardSuit: CardSuit)


enum class CardSuit {
    HEARTS,
    SPADES,
    CLUBS,
    DIAMONDS
}

enum class CardValue {
    TWO,
    THREE,
    FOUR,
    FIVE,
    SIX,
    SEVEN,
    EIGHT,
    NINE,
    TEN,
    JACK,
    QUEEN,
    KING,
    ACE
}