package me.ghisiluizgustavo.soccerapi.services;

import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.ghisiluizgustavo.soccerapi.exceptions.NotFoundException;
import me.ghisiluizgustavo.soccerapi.model.Player;
import me.ghisiluizgustavo.soccerapi.model.Team;
import me.ghisiluizgustavo.soccerapi.model.record.TeamRecord;
import me.ghisiluizgustavo.soccerapi.repositories.PlayerRepository;
import me.ghisiluizgustavo.soccerapi.repositories.TeamRepository;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class TeamService {

    private final PlayerRepository playerRepository;
    private final TeamRepository teamRepository;
    private final ConversionService conversionService;

    public Page<TeamRecord> getAllTeams(final Pageable pageable){
        return teamRepository
            .findAll(pageable)
            .map(team -> conversionService.convert(team, TeamRecord.class));
    }

    public TeamRecord getTeamById(final UUID id) {
        return teamRepository
            .findById(id)
            .map(team -> conversionService.convert(team, TeamRecord.class))
            .orElseThrow(() -> new NotFoundException("Team " + id  + " not found"));
    }

    public UUID create(final TeamRecord team) {
        Team teamCreated = createTeam(team);
        Optional
            .ofNullable(team.players())
            .ifPresent(players -> linkPlayers(players, teamCreated));
        return teamCreated.getId();
    }

    private void linkPlayers(final Set<Player> players, final Team team) {
        players.forEach(player ->
            playerRepository.updateTeamIdById(
                team,
                player
            )
        );
    }

    public Team createTeam(final TeamRecord team){
        return teamRepository.save(
            Objects.requireNonNull(
                conversionService.convert(team, Team.class)
            )
        );
    }
}
