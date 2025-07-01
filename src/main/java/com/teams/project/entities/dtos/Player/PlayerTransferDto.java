package com.teams.project.entities.dtos.Player;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerTransferDto {

    private Long playerId;
    private Long teamId;

}

