package me.ghisiluizgustavo.tournaments.controllers

import me.ghisiluizgustavo.tournaments.controllers.requests.TournamentRequest
import me.ghisiluizgustavo.tournaments.controllers.resources.TournamentResource
import me.ghisiluizgustavo.tournaments.controllers.responses.TournamentResponse
import me.ghisiluizgustavo.tournaments.services.TournamentService
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
class TournamentController(val tournamentService: TournamentService) : TournamentResource {

    override fun getAllTournaments(): Flux<TournamentResponse> =
        tournamentService.getAllTournaments().map { it.toDataClass() }

    override fun getTournamentById(id: String): Mono<TournamentResponse> =
        tournamentService.getById(id).map { it.toDataClass() }

    override fun createTournament(tournamentRequest: TournamentRequest) =
        tournamentService.create(tournamentRequest)

}