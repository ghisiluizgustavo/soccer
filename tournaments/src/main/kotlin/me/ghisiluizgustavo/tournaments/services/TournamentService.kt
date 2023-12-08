package me.ghisiluizgustavo.tournaments.services

import me.ghisiluizgustavo.tournaments.controllers.requests.TournamentRequest
import me.ghisiluizgustavo.tournaments.document.Tournament
import me.ghisiluizgustavo.tournaments.repositories.TournamentRepository
import org.bson.types.ObjectId
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class TournamentService(val tournamentRepository: TournamentRepository) {

    fun getAllTournaments(): Flux<Tournament> {
        return tournamentRepository.findAll()
    }

    fun getById(id: String): Mono<Tournament> {
        return tournamentRepository.findById(ObjectId(id))
    }

    fun create(tournamentRequest: TournamentRequest) {
        tournamentRepository.save(tournamentRequest.toEntity())
    }

}
