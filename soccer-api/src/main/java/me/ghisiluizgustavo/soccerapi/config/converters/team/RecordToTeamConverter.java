package me.ghisiluizgustavo.soccerapi.config.converters.team;

import me.ghisiluizgustavo.soccerapi.model.Team;
import me.ghisiluizgustavo.soccerapi.model.record.TeamRecord;
import org.springframework.core.convert.converter.Converter;

public class RecordToTeamConverter implements Converter<TeamRecord, Team> {

    @Override
    public Team convert(TeamRecord teamRecord) {
        return Team.builder()
            .name(teamRecord.name())
            .players(teamRecord.players())
            .build();
    }
}
