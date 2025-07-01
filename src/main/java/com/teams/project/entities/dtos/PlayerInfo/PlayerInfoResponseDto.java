package com.teams.project.entities.dtos.PlayerInfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class PlayerInfoResponseDto {
    private String playerName;
    private int count;
    private String cupName;


}