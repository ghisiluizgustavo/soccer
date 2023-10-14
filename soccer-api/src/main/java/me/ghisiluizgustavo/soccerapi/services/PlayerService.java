package me.ghisiluizgustavo.soccerapi.services;

import java.util.Objects;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.ghisiluizgustavo.soccerapi.exceptions.NotFoundException;
import me.ghisiluizgustavo.soccerapi.model.Player;
import me.ghisiluizgustavo.soccerapi.model.record.PlayerRecord;
import me.ghisiluizgustavo.soccerapi.model.record.TeamRecord;
import me.ghisiluizgustavo.soccerapi.repositories.PlayerRepository;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class PlayerService {

    private final PlayerRepository playerRepository;
    private final ConversionService conversionService;

    public Page<PlayerRecord> getAllPlayers(Pageable pageable){
        return playerRepository
            .findAll(pageable)
            .map(player -> conversionService.convert(player, PlayerRecord.class));
    }

    public PlayerRecord getPlayerById(UUID id) {
        return playerRepository
            .findById(id)
            .map(player -> conversionService.convert(player, PlayerRecord.class))
            .orElseThrow((() -> new NotFoundException("Player " + id + " not found")));
    }

    public UUID create(PlayerRecord player) {
        return playerRepository.save(
            Objects.requireNonNull(
                conversionService.convert(player, Player.class)
            )
        ).getId();
    }

    public void linkPlayer(UUID playerId, TeamRecord team) {
        playerRepository.linkPlayer(playerId, team.id());
    }
}
