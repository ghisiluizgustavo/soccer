package me.ghisiluizgustavo.tournaments.document

import me.ghisiluizgustavo.tournaments.controllers.requests.TournamentDTO
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("tournaments")
data class Tournament(
    @Id
    val id: String? = null,
    val name: String,
    val teams: List<String>,
    val initialDate: String,
    val finalDate: String
)