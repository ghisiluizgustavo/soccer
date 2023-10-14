package me.ghisiluizgustavo.soccerapi.model.record;

import java.time.LocalDate;
import java.util.UUID;
import me.ghisiluizgustavo.soccerapi.model.Team;
import org.springframework.validation.annotation.Validated;

public record PlayerRecord(
        UUID id,
        String name,
        LocalDate birthDate,
        String position,
        Team team
) { }
