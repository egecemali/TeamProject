package com.teams.project.dataAccess;

import com.teams.project.entities.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamDao extends JpaRepository<Team, Integer> {
    boolean existsByTeamId(Long teamId);

    boolean existsByTeam(String teamName);

    Team findByTeamId(Long teamId);
}
