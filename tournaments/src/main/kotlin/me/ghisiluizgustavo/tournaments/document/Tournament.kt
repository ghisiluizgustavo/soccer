package me.ghisiluizgustavo.tournaments.document

import me.ghisiluizgustavo.tournaments.controllers.responses.TournamentResponse
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
){
    fun toDataClass() = TournamentResponse(
        id = id,
        name = name,
        teams = teams,
        initialDate = initialDate,
        finalDate = finalDate
    )
}