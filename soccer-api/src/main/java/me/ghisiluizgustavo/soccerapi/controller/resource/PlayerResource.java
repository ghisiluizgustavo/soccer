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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@RequestMapping("api/v1/players")
public interface PlayerResource {

    @GetMapping
    Page<PlayerRecord> getAllPlayers(Pageable pageable);

    @GetMapping("/{id}")
    PlayerRecord getPlayerById(@PathVariable UUID id);

    @PostMapping()
    UUID create(@RequestBody PlayerRecord player);

    @PutMapping("/link/{playerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void link(@PathVariable UUID playerId, @RequestBody TeamRecord team);

}
