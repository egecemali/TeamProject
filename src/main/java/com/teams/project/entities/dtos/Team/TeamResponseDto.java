package com.teams.project.entities.dtos.Team;

import com.teams.project.entities.dtos.Player.PlayerShortResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeamResponseDto {
    private String team;
    private List<PlayerShortResponse> players;


}
