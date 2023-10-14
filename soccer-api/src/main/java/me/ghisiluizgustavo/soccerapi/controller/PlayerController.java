package me.ghisiluizgustavo.soccerapi.controller;

import java.util.UUID;
import lombok.RequiredArgsConstructor;
import me.ghisiluizgustavo.soccerapi.controller.resource.PlayerResource;
import me.ghisiluizgustavo.soccerapi.model.record.PlayerRecord;
import me.ghisiluizgustavo.soccerapi.model.record.TeamRecord;
import me.ghisiluizgustavo.soccerapi.services.PlayerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PlayerController implements PlayerResource {

    private final PlayerService playerService;

    @Override
    public Page<PlayerRecord> getAllPlayers(Pageable pageable) {
        return playerService.getAllPlayers(pageable);
    }

    @Override
    public PlayerRecord getPlayerById(final UUID id) {
        return playerService.getPlayerById(id);
    }

    @Override
    public UUID create(final PlayerRecord player) {
        return playerService.create(player);
    }

    @Override
    public void link(final UUID playerId, TeamRecord team) {
        playerService.linkPlayer(playerId, team);
    }

}
