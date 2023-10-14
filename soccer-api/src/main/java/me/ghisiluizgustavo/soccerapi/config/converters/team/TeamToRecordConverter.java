package me.ghisiluizgustavo.soccerapi.config.converters.team;

import me.ghisiluizgustavo.soccerapi.model.Team;
import me.ghisiluizgustavo.soccerapi.model.record.TeamRecord;
import org.springframework.core.convert.converter.Converter;

public class TeamToRecordConverter implements Converter<Team, TeamRecord> {


    @Override
    public TeamRecord convert(Team team) {
        return new TeamRecord(
            team.getId(),
            team.getName(),
            team.getPlayers()
        );
    }
}
