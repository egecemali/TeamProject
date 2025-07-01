package com.teams.project.api.controllers;

import com.teams.project.business.PlayerInfoService;
import com.teams.project.entities.dtos.PlayerInfo.PlayerInfoRequestDto;
import com.teams.project.entities.dtos.PlayerInfo.PlayerInfoResponseDto;
import com.teams.project.entities.dtos.PlayerInfo.PlayerInfoUpdateDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/playerInfo")
@AllArgsConstructor

public class PlayerInfoController {

    private PlayerInfoService playerInfoService;

    

    @GetMapping("/getAll")
    public ResponseEntity<List<PlayerInfoResponseDto>> getPlayerInfos() {
        return ResponseEntity.ok(playerInfoService.getPlayerInfos());
    }
    @PostMapping("/add")
    public ResponseEntity<PlayerInfoResponseDto> addPlayerInfo(@RequestBody  PlayerInfoRequestDto playerInfoRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(playerInfoService.addPlayerInfo(playerInfoRequestDto));

    }
    @PutMapping("/update")
    public ResponseEntity<PlayerInfoResponseDto> updatePlayerInfo(@RequestBody PlayerInfoUpdateDto playerInfoUpdateDto) {
        return ResponseEntity.ok(playerInfoService.updatePlayerInfo(playerInfoUpdateDto));
    }
}
