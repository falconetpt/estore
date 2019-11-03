package com.rfgomes.poker.match

import com.rfgomes.poker.deck.Deck
import com.rfgomes.poker.player.Player

class Match(val id: String,
            val version: Int = 1,
            val players: List<Player>,
            val deck: Deck) {

}