package com.teams.project.dataAccess;

import com.teams.project.entities.Cup;
import com.teams.project.entities.Player;
import com.teams.project.entities.PlayerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerInfoDao extends JpaRepository<PlayerInfo,Integer> {

    boolean existsByCup(Cup cup);
    boolean existsByPlayer(Player player);

    PlayerInfo findByPlayerInfoId(Long id);
}
