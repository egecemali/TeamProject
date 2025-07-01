package com.teams.project.entities.dtos.Player;

import com.teams.project.entities.enums.Region;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerShortResponse {
    private String playerName;
    private String playerSurname;
    private Region region;

}
