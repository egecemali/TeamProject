package com.teams.project.business.rules;

import com.teams.project.business.CupService;
import com.teams.project.core.utilities.exceptions.BusinessExeption;
import com.teams.project.dataAccess.PlayerInfoDao;
import com.teams.project.entities.Cup;
import com.teams.project.entities.Player;
import com.teams.project.entities.PlayerInfo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor

public class PlayerInfoBusinessRules {

    private final PlayerInfoDao playerInfoDao;
    private final CupService cupService;


    public void checkIfPlayerInfoExistForSameCupId(Player player, Cup cup) {
        if (playerInfoDao.existsByPlayer(player) && playerInfoDao.existsByCup(cup)) {
            throw new BusinessExeption("There is already cup for this player.Please update the count of the player's info.");
        }
    }


}
