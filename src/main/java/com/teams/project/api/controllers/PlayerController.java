package com.teams.project.api.controllers;

import com.teams.project.business.PlayerService;
import com.teams.project.entities.Player;
import com.teams.project.entities.dtos.Player.PlayerRequestDto;
import com.teams.project.entities.dtos.Player.PlayerResponseDto;
import com.teams.project.entities.dtos.Player.PlayerTransferDto;
import com.teams.project.entities.dtos.Player.PlayerUpdateDto;
import com.teams.project.entities.enums.Region;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/players")
@AllArgsConstructor
public class PlayerController {
    private final PlayerService playerService;


    @GetMapping("/getAll")
    public ResponseEntity<List<PlayerResponseDto>> getPlayers() {
        return ResponseEntity.ok(playerService.getPlayers());
        }
    @GetMapping("/get/{id}")
    public ResponseEntity<PlayerResponseDto> getPlayer(@PathVariable Long id) {
        return ResponseEntity.ok(playerService.getPlayer(id));
    }
    @GetMapping("/getByRegion/{region}")
    public ResponseEntity<List<PlayerResponseDto>> getPlayer(@PathVariable Region region) {
        return ResponseEntity.ok().body(playerService.getPlayersByRole(region));
    }
    @PostMapping("/add")
    public ResponseEntity<String> addPlayer(@RequestBody @Valid PlayerRequestDto playerRequestDto) {
        playerService.addPlayer(playerRequestDto);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Add player successfully");

    }
    @PostMapping("/update")
    public ResponseEntity<Player> updatePlayer(@RequestBody PlayerUpdateDto playerUpdateDto) {
        playerService.updatePlayer(playerUpdateDto);
        return ResponseEntity.ok().body(playerService.updatePlayer(playerUpdateDto));
        }

    @DeleteMapping("/delete/{playerId}")
    public ResponseEntity<Void> deletePlayer(@PathVariable Long playerId) {
        playerService.deletePlayer(playerId);
        return ResponseEntity.ok().build();

    }
    @PutMapping("/transfer")
    public ResponseEntity<String> transferPlayer(@RequestBody @Valid PlayerTransferDto playerTransferDto) {
        playerService.transferPlayer(playerTransferDto.getPlayerId(), playerTransferDto.getTeamId());
        return ResponseEntity.ok().body("Transfer player successfully");
    }
    @GetMapping("/getAll/{price}")
    public ResponseEntity<List<PlayerResponseDto>> getPlayers(@PathVariable Double price) {
        return ResponseEntity.ok().body(playerService.getPlayersByPrice(price));
    }
    @GetMapping("/getStadiumName/{playerId}")
    public ResponseEntity<String> getStadiumName(@PathVariable Long playerId) {
        return ResponseEntity.ok(playerService.getStadiumByPlayerId(playerId));
    }


}

