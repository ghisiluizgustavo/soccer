package me.ghisiluizgustavo.soccerapi.repositories;

import java.time.LocalDate;
import java.util.Optional;
import me.ghisiluizgustavo.soccerapi.model.Player;
import me.ghisiluizgustavo.soccerapi.model.Team;
import me.ghisiluizgustavo.soccerapi.model.record.TeamRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface PlayerRepository extends JpaRepository<Player, UUID> {

    @Transactional
    @Modifying
    @Query("update Player p set p.team = ?1 where p = ?2")
    void updateTeamIdById(Team team, Player player);

    @Transactional
    @Modifying
    @Query("update Player p set p.team.id = ?2 where p.id = ?1")
    void linkPlayer(UUID playerId, UUID teamId);
}
