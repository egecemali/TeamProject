package com.teams.project.entities.dtos.Team;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class TeamIdResponseDto {
    private int teamId;
    private String team;


}
