package com.teams.project.dataAccess;

import com.teams.project.entities.Player;
import com.teams.project.entities.Team;
import com.teams.project.entities.enums.Region;
import jakarta.validation.constraints.Max;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PlayerDao extends JpaRepository<Player, Long> {
    List<Player> findByRegion(Region region);

    // :age --> dışarıdan gelecek parametre
    @Query("select p FROM Player p WHERE p.marketValue >= :price")
    List<Player> findPlayersByPrice(@Param("price") double price);

    @Query("select t.stadiumName FROM Player p JOIN p.team t WHERE p.playerId = :playerId ")
    String findStadiumNameByPlayerId(Long playerId);
}
