package com.teams.project.business.rules;

import com.teams.project.core.utilities.exceptions.AlreadyExistException;
import com.teams.project.core.utilities.exceptions.BusinessExeption;
import com.teams.project.dataAccess.TeamDao;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TeamBusinessRules {
    private TeamDao teamDao;

    public void checkIfTeamNameExists(String teamName) {
        if (this.teamDao.existsByTeam(teamName)) {
            throw new AlreadyExistException("Team name already exists in database : " + teamName);
        }
    }
    public void checkIfTeamIdExists(Long teamId) {
        if (!this.teamDao.existsByTeamId(teamId)) {
            throw new BusinessExeption("Team id not exists in database : " + teamId);

        }
    }
}