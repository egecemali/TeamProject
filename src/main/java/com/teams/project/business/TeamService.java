package com.teams.project.business;

import com.teams.project.business.rules.TeamBusinessRules;
import com.teams.project.core.utilities.mappers.ModelMapperService;
import com.teams.project.dataAccess.TeamDao;
import com.teams.project.entities.Team;
import com.teams.project.entities.dtos.Team.TeamIdResponseDto;
import com.teams.project.entities.dtos.Team.TeamResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TeamService {
    private final TeamDao teamDao;
    private final ModelMapperService modelMapperService;
    private final TeamBusinessRules teamBusinessRules;


    public Team addTeam(Team team) {
        teamBusinessRules.checkIfTeamNameExists(team.getTeam());
        return teamDao.save(team);
    }

    public List<TeamResponseDto> getTeams(){
        List<Team> teams = teamDao.findAll();
        List<TeamResponseDto> teamResponseDtos = teams.stream().map(team -> modelMapperService.getModelMapperForResponseDto().map(team,TeamResponseDto.class)).toList();
        return teamResponseDtos;
    }
    public TeamResponseDto getTeam(int teamId) {
        Team team = teamDao.findById(teamId).orElseThrow(() -> new IllegalArgumentException("Team not found"));
        return modelMapperService.getModelMapperForResponseDto().map(team, TeamResponseDto.class);

    }
    public List<TeamIdResponseDto> getTeamIds() {
        List<Team> teams = teamDao.findAll();
        List<TeamIdResponseDto> teamIdResponseDtos = teams.stream().map(team -> modelMapperService.getModelMapperForResponseDto().map(team, TeamIdResponseDto.class)).toList();
        return teamIdResponseDtos;
    }




}

