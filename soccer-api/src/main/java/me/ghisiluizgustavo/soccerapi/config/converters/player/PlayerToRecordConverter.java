package me.ghisiluizgustavo.soccerapi.config.converters.player;

import me.ghisiluizgustavo.soccerapi.model.Player;
import me.ghisiluizgustavo.soccerapi.model.record.PlayerRecord;
import org.springframework.core.convert.converter.Converter;

public class PlayerToRecordConverter implements Converter<Player, PlayerRecord> {

    @Override
    public PlayerRecord convert(Player player) {
        return new PlayerRecord(
            player.getId(),
            player.getName(),
            player.getBirthDate(),
            player.getPosition(),
            player.getTeam()
        );
    }
}
