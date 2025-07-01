package com.teams.project.business.rules;

import com.teams.project.core.utilities.exceptions.BusinessExeption;
import com.teams.project.dataAccess.PlayerDao;
import com.teams.project.dataAccess.TeamDao;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PlayerBusinessRules {
    private PlayerDao playerDao;
    private TeamDao teamDao;

    public void checkIfTeamIdExists(int teamId) {
        if (!teamDao.existsById(teamId)) {
            throw new BusinessExeption("Error : This team id does not exist in the database :" + teamId);
        }
    }
    public void checkIfPlayerIdExists(long playerId) {
        if (!playerDao.existsById(playerId)){
            throw new BusinessExeption("Error : This player id does not exist in the database : " + playerId);
        }
    }
    public void checkIfPlayerNameNullOrEmpty(String playerName) {
        if (playerName == null || playerName.isEmpty()) {
            throw new BusinessExeption("Error : Player name cannot be null or empty !");

        }
    }
}