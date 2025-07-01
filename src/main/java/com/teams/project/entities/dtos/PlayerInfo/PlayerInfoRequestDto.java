package com.teams.project.entities.dtos.PlayerInfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class PlayerInfoRequestDto {
    private Long playerId;
    private int count;
    private Long cupId;


}