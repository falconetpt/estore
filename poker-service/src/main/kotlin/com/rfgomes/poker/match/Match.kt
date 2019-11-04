package com.rfgomes.poker.match

import com.rfgomes.poker.deck.Deck
import com.rfgomes.poker.player.Player
import com.rfgomes.poker.table.Table

class Match(val id: String, val players: List<Player>,
            val table: Table, val deck: Deck,
            val smallBlind: Int, val bigBlind: Int,
            var version: Int = 1) {

}