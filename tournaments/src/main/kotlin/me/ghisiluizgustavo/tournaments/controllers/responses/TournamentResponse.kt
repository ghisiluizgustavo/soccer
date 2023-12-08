package me.ghisiluizgustavo.tournaments.controllers.responses

data class TournamentResponse(
    val id: String?,
    val name: String,
    val teams: List<String>,
    val initialDate: String,
    val finalDate: String
)
