package com.Business.service;

import com.Business.dto.PlayerDTO;

public interface PlayerService {
    Long createPlayer(String playerName);
    PlayerDTO getPlayerInfo(Long playerId);
    // Add other methods as needed
}
