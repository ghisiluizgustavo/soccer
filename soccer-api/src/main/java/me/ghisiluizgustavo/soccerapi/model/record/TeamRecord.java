package me.ghisiluizgustavo.soccerapi.model.record;

import java.util.Set;
import java.util.UUID;
import me.ghisiluizgustavo.soccerapi.model.Player;
import me.ghisiluizgustavo.soccerapi.model.Team;

public record TeamRecord(
    UUID id,
    String name,
    Set<Player> players
) { }
