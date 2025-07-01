package com.teams.project.entities.dtos.PlayerInfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerInfoUpdateDto {
    private Long playerInfoId;
    private int count;

}
