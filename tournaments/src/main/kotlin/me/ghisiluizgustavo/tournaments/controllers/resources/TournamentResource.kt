package me.ghisiluizgustavo.tournaments.controllers.resources

import me.ghisiluizgustavo.tournaments.controllers.requests.TournamentRequest
import me.ghisiluizgustavo.tournaments.controllers.responses.TournamentResponse
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono


@RequestMapping("/api/v1/tournaments")
interface TournamentResource {


    @GetMapping
    fun getAllTournaments(): Flux<TournamentResponse>

    @GetMapping("/{id}")
    fun getTournamentById(@PathVariable id: String): Mono<TournamentResponse>

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createTournament(tournamentRequest: TournamentRequest)

}