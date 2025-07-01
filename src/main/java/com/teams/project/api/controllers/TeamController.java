package com.teams.project.api.controllers;

import com.teams.project.business.TeamService;
import com.teams.project.entities.Team;
import com.teams.project.entities.dtos.Team.TeamIdResponseDto;
import com.teams.project.entities.dtos.Team.TeamResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teams")
@AllArgsConstructor
public class TeamController {
    private final TeamService teamService;


    @GetMapping("/getAll")
    public ResponseEntity<List<TeamResponseDto>> getTeams(){
        return ResponseEntity.ok(teamService.getTeams());

    }
    @GetMapping("/get/{teamId}")
    public ResponseEntity<TeamResponseDto> getTeam(@PathVariable int teamId) {
        return  ResponseEntity.ok(teamService.getTeam(teamId));

    }
    @GetMapping("/getWithId")
    public ResponseEntity<List<TeamIdResponseDto>> getTeamsWithId(){
        return ResponseEntity.ok(teamService.getTeamIds());

    }
    @PostMapping("/add")

    public ResponseEntity<Team> addTeam(@RequestBody Team team){
        return ResponseEntity.status(HttpStatus.CREATED).body(teamService.addTeam(team));
    }







}
