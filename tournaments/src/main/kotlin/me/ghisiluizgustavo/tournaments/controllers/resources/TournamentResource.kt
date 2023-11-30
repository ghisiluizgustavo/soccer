package me.ghisiluizgustavo.tournaments.controllers.resources

import me.ghisiluizgustavo.tournaments.controllers.requests.TournamentRequest
import me.ghisiluizgustavo.tournaments.document.Tournament
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono


@RequestMapping("/api/v1/tournaments")
interface TournamentResource {


    @GetMapping
    fun getAllTournaments(): Flux<Tournament>

    @GetMapping("/{id}")
    fun getTournamentById(@PathVariable id: String): Mono<Tournament>

    @PostMapping
    fun createTournament(tournamentRequest: TournamentRequest)

}