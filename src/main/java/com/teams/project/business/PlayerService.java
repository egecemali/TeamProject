package com.teams.project.business;

import com.teams.project.business.rules.PlayerBusinessRules;
import com.teams.project.business.rules.TeamBusinessRules;
import com.teams.project.core.utilities.mappers.ModelMapperService;
import com.teams.project.dataAccess.PlayerDao;
import com.teams.project.dataAccess.TeamDao;
import com.teams.project.entities.Player;
import com.teams.project.entities.dtos.Player.PlayerRequestDto;
import com.teams.project.entities.dtos.Player.PlayerResponseDto;
import com.teams.project.entities.dtos.Player.PlayerUpdateDto;
import com.teams.project.entities.enums.Region;
import lombok.AllArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//import static com.teams.project.core.utilities.rabbit.RabbitMQConfig.QUEUE_NAME;
//import static com.teams.project.core.utilities.rabbit.RabbitMQConfig.ROUTING_KEY;

@Service
@AllArgsConstructor
public class PlayerService {
    private final TeamDao teamDao;
    //private final Exchange exchange;
    private final TeamBusinessRules teamBusinessRules;
    private PlayerDao playerDao;
    private ModelMapperService modelMapperService;
    private PlayerBusinessRules playerBusinessRules;
    //private AmqpTemplate rabbitTemplate;


    //public void addPlayer(PlayerRequestDto playerRequestDto) {
        //rabbitTemplate.convertAndSend(exchange.getName(),ROUTING_KEY,playerRequestDto);
    //}
    @Transactional
    //@RabbitListener(queues = QUEUE_NAME)
    public void addPlayer(PlayerRequestDto playerRequestDto) {
        playerBusinessRules.checkIfPlayerNameNullOrEmpty(playerRequestDto.getPlayerName());
        playerBusinessRules.checkIfTeamIdExists(playerRequestDto.getTeamId());
        Player player = modelMapperService.getModelMapperForRequestDto().map(playerRequestDto, Player.class);
        player.setTeam(teamDao.findById(playerRequestDto.getTeamId()).orElseThrow());
        playerDao.save(player);
    }
    public List<PlayerResponseDto> getPlayers() {
            List<Player> players = playerDao.findAll();
            List<PlayerResponseDto> playerResponseDtos = players.stream().map(player -> modelMapperService.getModelMapperForResponseDto().map(player, PlayerResponseDto.class)).toList();

            return playerResponseDtos;
    }
    public void deletePlayer(Long playerId) {
        playerBusinessRules.checkIfPlayerIdExists(playerId);
        playerDao.deleteById(playerId);

    }
    public PlayerResponseDto getPlayer(Long playerId) {
        playerBusinessRules.checkIfPlayerIdExists(playerId);
        Player player = playerDao.findById(playerId).orElseThrow();
        return modelMapperService.getModelMapperForResponseDto().map(player, PlayerResponseDto.class);

    }
    public Player updatePlayer(PlayerUpdateDto playerUpdateDto) {
        playerBusinessRules.checkIfPlayerIdExists(playerUpdateDto.getPlayerId());
        Player player = playerDao.findById(playerUpdateDto.getPlayerId()).orElse(null);
        modelMapperService.getModelMapperForRequestDto().map(playerUpdateDto, player);
        playerDao.save(player);
        return player;

    }
    public List<PlayerResponseDto> getPlayersByRole(Region region) {
        List<Player> players = playerDao.findByRegion(region);
        List<PlayerResponseDto> playerResponseDtos = players.stream().map(player -> modelMapperService.getModelMapperForResponseDto().map(player,PlayerResponseDto.class)).toList();
        return playerResponseDtos;
    }
    public void transferPlayer(Long playerId, Long teamId ) {
        playerBusinessRules.checkIfPlayerIdExists(playerId);
        teamBusinessRules.checkIfTeamIdExists(teamId);
        Player player = playerDao.findById(playerId).orElseThrow();
        modelMapperService.getModelMapperForRequestDto().map(player, PlayerResponseDto.class);
        player.setTeam(teamDao.findByTeamId(teamId));
        playerDao.save(player);


    }
    public List<PlayerResponseDto> getPlayersByPrice(double price) {
        List<Player> players =  playerDao.findPlayersByPrice(price);
        List<PlayerResponseDto> playersDto = players.stream().map(player -> modelMapperService.getModelMapperForResponseDto().map(player, PlayerResponseDto.class)).toList();
        return playersDto;

    }
    public String getStadiumByPlayerId(Long playerId) {
        playerBusinessRules.checkIfPlayerIdExists(playerId);
       return playerDao.findStadiumNameByPlayerId(playerId);
    }


}

