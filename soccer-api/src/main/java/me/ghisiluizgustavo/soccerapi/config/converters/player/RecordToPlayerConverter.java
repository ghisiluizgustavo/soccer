package me.ghisiluizgustavo.soccerapi.config.converters.player;

import me.ghisiluizgustavo.soccerapi.model.Player;
import me.ghisiluizgustavo.soccerapi.model.record.PlayerRecord;
import org.springframework.core.convert.converter.Converter;

public class RecordToPlayerConverter implements Converter<PlayerRecord, Player> {

    @Override
    public Player convert(PlayerRecord player) {
        return Player.builder()
            .birthDate(player.birthDate())
            .name(player.name())
            .position(player.position())
            .team(player.team())
            .build();
    }
}
