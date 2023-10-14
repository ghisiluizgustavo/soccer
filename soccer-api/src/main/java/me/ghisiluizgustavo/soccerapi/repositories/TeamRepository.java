package me.ghisiluizgustavo.soccerapi.repositories;

import java.util.UUID;
import me.ghisiluizgustavo.soccerapi.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, UUID> {

}
