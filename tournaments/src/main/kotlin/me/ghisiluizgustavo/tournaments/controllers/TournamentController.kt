package me.ghisiluizgustavo.tournaments.controllers

import me.ghisiluizgustavo.tournaments.controllers.requests.TournamentRequest
import me.ghisiluizgustavo.tournaments.document.Tournament
import me.ghisiluizgustavo.tournaments.controllers.resources.TournamentResource
import me.ghisiluizgustavo.tournaments.services.TournamentService
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
class TournamentController(val tournamentService: TournamentService) : TournamentResource {

    override fun getAllTournaments(): Flux<Tournament> = tournamentService.getAllTournaments()

    override fun getTournamentById(id: String): Mono<Tournament> = tournamentService.getById(id)

    override fun createTournament(tournamentRequest: TournamentRequest) {
        TODO("Not yet implemented")
    }


}