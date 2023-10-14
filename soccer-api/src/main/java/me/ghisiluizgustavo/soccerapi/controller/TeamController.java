package me.ghisiluizgustavo.soccerapi.controller;

import java.util.UUID;
import lombok.RequiredArgsConstructor;
import me.ghisiluizgustavo.soccerapi.controller.resource.PlayerResource;
import me.ghisiluizgustavo.soccerapi.controller.resource.TeamResource;
import me.ghisiluizgustavo.soccerapi.model.record.PlayerRecord;
import me.ghisiluizgustavo.soccerapi.model.record.TeamRecord;
import me.ghisiluizgustavo.soccerapi.repositories.TeamRepository;
import me.ghisiluizgustavo.soccerapi.services.PlayerService;
import me.ghisiluizgustavo.soccerapi.services.TeamService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TeamController implements TeamResource {

    private final TeamService teamService;

    @Override
    public Page<TeamRecord> getAllTeams(Pageable pageable) {
        return teamService.getAllTeams(pageable);
    }

    @Override
    public TeamRecord getTeamById(UUID id) {
        return teamService.getTeamById(id);
    }

    @Override
    public UUID create(TeamRecord team) {
        return teamService.create(team);
    }
}
