package me.ghisiluizgustavo.tournaments.repositories

import me.ghisiluizgustavo.tournaments.document.Tournament
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.ReactiveMongoRepository

interface TournamentRepository: ReactiveMongoRepository<Tournament, ObjectId> {}
