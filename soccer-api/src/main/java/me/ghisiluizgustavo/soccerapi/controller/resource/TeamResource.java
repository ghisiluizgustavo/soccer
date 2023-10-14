package me.ghisiluizgustavo.soccerapi.controller.resource;


import java.util.UUID;
import me.ghisiluizgustavo.soccerapi.model.record.PlayerRecord;
import me.ghisiluizgustavo.soccerapi.model.record.TeamRecord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@RequestMapping("api/v1/teams")
public interface TeamResource {

    @GetMapping
    Page<TeamRecord> getAllTeams(Pageable pageable);

    @GetMapping("/{id}")
    TeamRecord getTeamById(@PathVariable UUID id);

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    UUID create(@RequestBody TeamRecord team);

}
