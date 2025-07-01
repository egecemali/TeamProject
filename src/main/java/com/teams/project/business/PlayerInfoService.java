package com.teams.project.business;

import com.teams.project.business.rules.CupBusinessRules;
import com.teams.project.business.rules.PlayerBusinessRules;
import com.teams.project.business.rules.PlayerInfoBusinessRules;
import com.teams.project.core.utilities.mappers.ModelMapperService;
import com.teams.project.dataAccess.CupDao;
import com.teams.project.dataAccess.PlayerDao;
import com.teams.project.dataAccess.PlayerInfoDao;

import com.teams.project.entities.Cup;
import com.teams.project.entities.Player;
import com.teams.project.entities.PlayerInfo;
import com.teams.project.entities.dtos.PlayerInfo.PlayerInfoRequestDto;
import com.teams.project.entities.dtos.PlayerInfo.PlayerInfoResponseDto;
import com.teams.project.entities.dtos.PlayerInfo.PlayerInfoUpdateDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class PlayerInfoService {

    private PlayerInfoDao playerInfoDao;
    private ModelMapperService modelMapperService;
    private PlayerDao playerDao;
    private CupDao cupDao;
    private PlayerInfoBusinessRules playerInfoBusinessRules;
    private PlayerBusinessRules playerBusinessRules;
    private CupBusinessRules cupBusinessRules;


    public PlayerInfoResponseDto addPlayerInfo(PlayerInfoRequestDto playerInfoRequestDto) {
        cupBusinessRules.checkIfCupIdExists(playerInfoRequestDto.getCupId());
        playerBusinessRules.checkIfPlayerIdExists(playerInfoRequestDto.getPlayerId());
        Player player = playerDao.findById(playerInfoRequestDto.getPlayerId()).orElse(null);
        Cup cup = cupDao.findById(playerInfoRequestDto.getCupId()).orElse(null);
        playerInfoBusinessRules.checkIfPlayerInfoExistForSameCupId(player, cup);
        PlayerInfo playerInfo = modelMapperService.getModelMapperForRequestDto().map(playerInfoRequestDto, PlayerInfo.class);
        playerInfo.setPlayer(playerDao.findById(playerInfoRequestDto.getPlayerId()).orElse(null));
        playerInfo.setCup(cupDao.findById(playerInfoRequestDto.getCupId()).orElse(null));
        playerInfoDao.save(playerInfo);
        PlayerInfoResponseDto playerInfoResponseDto = modelMapperService.getModelMapperForResponseDto().map(playerInfo, PlayerInfoResponseDto.class);
        return playerInfoResponseDto;
    }
    public List<PlayerInfoResponseDto> getPlayerInfos() {
        List<PlayerInfo> playerInfos = playerInfoDao.findAll();
        List<PlayerInfoResponseDto> playerInfoResponseDto = playerInfos.stream().map(playerInfo -> modelMapperService.getModelMapperForResponseDto().map(playerInfo, PlayerInfoResponseDto.class)).toList();

        return playerInfoResponseDto;
            }

    public PlayerInfoResponseDto updatePlayerInfo(PlayerInfoUpdateDto playerInfoUpdateDto) {
        PlayerInfo playerInfo = modelMapperService.getModelMapperForResponseDto().map(playerInfoUpdateDto, PlayerInfo.class);
        playerInfo.setPlayer(playerInfoDao.findByPlayerInfoId(playerInfoUpdateDto.getPlayerInfoId()).getPlayer());
        playerInfo.setCup(playerInfoDao.findByPlayerInfoId(playerInfoUpdateDto.getPlayerInfoId()).getCup());
        playerInfoDao.save(playerInfo);
        PlayerInfoResponseDto playerInfoResponseDto = modelMapperService.getModelMapperForResponseDto().map(playerInfo, PlayerInfoResponseDto.class);
        return playerInfoResponseDto;
    }

}
