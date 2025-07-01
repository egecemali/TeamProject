package com.teams.project.entities.dtos.Player;

import com.teams.project.entities.enums.Region;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PlayerResponseDto {

    private int playerId;
    private String playerName;
    private Region region;
    private String playerSurname;
    private int age;
    private String nationality;
    private int marketValue;
    private String team;

}
