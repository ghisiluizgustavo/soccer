package me.ghisiluizgustavo.tournaments.controllers.requests

import me.ghisiluizgustavo.tournaments.document.Tournament

data class TournamentRequest(
    val name: String,
    val teams: List<String>,
    val initialDate: String,
    val finalDate: String
) {
    fun toEntity() = Tournament(
        name = name,
        teams = teams,
        initialDate = initialDate,
        finalDate = initialDate
    )
}
