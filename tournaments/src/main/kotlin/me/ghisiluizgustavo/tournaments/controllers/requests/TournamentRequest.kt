package me.ghisiluizgustavo.tournaments.controllers.requests

data class TournamentRequest(
    val name: String,
    val teams: List<String>,
    val initialDate: String,
    val finalDate: String
)
